package com.hu.login.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author hu
 * @date 2021/12/3
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
public class RedisConfigTest {

    @Autowired
    private RedisConfig redisConfig;

    @Test
    public void test() {
        System.out.println(redisConfig);
        LettuceConnectionFactory lettuceConnectionFactory = redisConfig.redisConnectionFactory();
//        System.out.println(lettuceConnectionFactory.getConnection());
        RedisTemplate<String, Object> redisTemplate = redisConfig.getRedisTemplate(lettuceConnectionFactory);
        System.out.println(redisTemplate);
    }

    @Test
    public void test2() {
        int number = (int) (Math.random() * 1000) + 1;
        System.out.println(number);
    }

}
