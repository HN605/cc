package com.example.demo;

import com.example.demo.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisTest extends DemoApplicationTests {

    //自动配置默认创建了两个RedisTemplate
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Test
    public void redisTemplateTest() {
        Person person = new Person("cccccc", 23);
        redisTemplate.opsForValue().set("person_02", person);
        Person person1 = (Person) redisTemplate.opsForValue().get("person_01");
        System.out.println(person1.getName() + ":" + person1.getAge());
    }

    /*@Test
    @Ignore
    public void test() {
        Jedis jedis = new Jedis("localhost", 6379, 10000);
        int i = 0;
        try {
            long start = System.currentTimeMillis();
            while (true) {
                long end = System.currentTimeMillis();
                if (end - start >= 1000) {
                    break;
                }

                i++;
                jedis.set("test" + i, i + "");
            }
        } finally {
            jedis.close();
        }

        System.out.println("redis每秒操作：" + i + "次");
    }

    @Test
    @Ignore
    public void test2() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        // 最大空闲数
        poolConfig.setMaxIdle(50);
        // 最大连接数
        poolConfig.setMaxTotal(100);
        // 最大等待毫秒数
        poolConfig.setMaxWaitMillis(20000);
        // 使用配置创建连接池
        JedisPool pool = new JedisPool(poolConfig, "localhost");
        // 从连接池中获取单个连接
        Jedis jedis = pool.getResource();
        // 如果需要密码 //jedis.auth("password");

        jedis.set("chen", "chuang");

        jedis.close();

    }*/
}
