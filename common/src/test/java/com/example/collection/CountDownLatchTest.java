package com.example.collection;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {

                    int time = random.nextInt(5);
                    System.out.println(Thread.currentThread().getName() + "开始出发");
                    try {
                        TimeUnit.SECONDS.sleep(time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "到达车站了" + "在路上耗时" + time + "秒");
                    countDownLatch.countDown();
                }
            }).start();
        }
        System.out.println("司机等待乘客！");
        countDownLatch.await();
        System.out.println("老司机，发车！");
    }
}