package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
//import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {

//    @Bean
//    public JedisPoolConfig getJedisPoolConfig() {
//        JedisPoolConfig poolConfig = new JedisPoolConfig();
//        // 最大空闲数
//        poolConfig.setMaxIdle(50);
//        // 最大连接数
//        poolConfig.setMaxTotal(100);
//        // 最大等待毫秒数
//        poolConfig.setMaxWaitMillis(20000);
//
//        return poolConfig;
//    }
//
//    @Bean
//    public JedisConnectionFactory getJedisConnectionFactory(JedisPoolConfig poolConfig) {
//        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
//        configuration.setHostName("localhost");
//        configuration.setPort(6379);
//
//        JedisClientConfiguration jedisClientConfiguration = JedisClientConfiguration.builder()
//                .usePooling()
//                .poolConfig(poolConfig)
//                .build();
//
//        return new JedisConnectionFactory(configuration, jedisClientConfiguration);
//    }

//    @Bean
//    public RedisTemplate<String, Object> getRedisTemplate(JedisConnectionFactory connectionFactory) {
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(connectionFactory);
//
//        return redisTemplate;
//    }
}
