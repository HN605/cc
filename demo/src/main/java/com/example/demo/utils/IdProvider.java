package com.example.demo.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.Inet4Address;

/**
 * 分布式 环境下，生成主键 id 。
 */

@Component
@Slf4j
public class IdProvider {

    private final long twepoch = 1489111610226L;

    private final long workerIdBits = 5L;

    private final long dataCenterIdBits = 5L;

    private final long maxWorkerId = -1L ^ (-1L << workerIdBits);

    private final long maxDataCenterId = -1L ^ (-1L << dataCenterIdBits);

    private final long sequenceBits = 12L;

    private final long workerIdShift = sequenceBits;

    private final long dataCenterIdShift = sequenceBits + workerIdBits;

    private final long timestampLeftShift = sequenceBits + workerIdBits + dataCenterIdBits;

    private final long sequenceMask = -1L ^ (-1L << sequenceBits);

    // 工作ID (0~31)
    private long workerId;

    //数据中心ID (0~31)
    private long dataCenterId;

    private long sequence = 0L;

    private long lastTimestamp = -1L;


    /**
     *
     */
    @PostConstruct
    public void init() {
        log.info("init id component ....................");
        this.workerId = getWorkId();
        this.dataCenterId = getDataCenterId();
    }


    /**
     * 生成ID (该方法是线程安全的)
     */
    public long generatorId() {
        long timestamp = timeGen();

        if (timestamp < lastTimestamp) {
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }

        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0L;
        }

        lastTimestamp = timestamp;

        long id = ((timestamp - twepoch) << timestampLeftShift)
                | (dataCenterId << dataCenterIdShift)
                | (workerId << workerIdShift)
                | sequence;

        log.info("id 生成功：" + id);
        return id;
    }


    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    /**
     * 返回以毫秒为单位的当前时间
     *
     * @return 当前时间(毫秒)
     */
    protected long timeGen() {
        return System.currentTimeMillis();
    }


    private Long getWorkId() {
        try {
            String hostAddress = Inet4Address.getLocalHost().getHostAddress();
            int[] ints = StringUtils.toCodePoints(hostAddress);
            int sums = 0;
            for (int b : ints) {
                sums += b;
            }
            return (long) (sums % 32);
        } catch (Exception e) {
            return RandomUtils.nextLong(0, 31);
        }
    }


    private Long getDataCenterId() {
        try {
            int[] ints = StringUtils.toCodePoints(SystemUtils.getHostName());
            int sums = 0;
            for (int i : ints) {
                sums += i;
            }
            return (long) (sums % 32);
        } catch (Exception e) {
            return RandomUtils.nextLong(0, 31);
        }
    }


    //==============================Test=============================================

    /**
     * 测试
     */
    public static void main(String[] args) {

        //经测试，每秒可以产生 20W 的 id
        IdProvider provider = new IdProvider();
        provider.init();

        long startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 10; j++) {
                long id = provider.generatorId();
                System.out.println(id);
            }
        }
        System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");
    }


}
