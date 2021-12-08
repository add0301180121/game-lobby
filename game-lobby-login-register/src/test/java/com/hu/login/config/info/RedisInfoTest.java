package com.hu.login.config.info;

import com.hu.login.config.DataConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author hu
 * @date 2021/12/4
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
public class RedisInfoTest {

    @Resource
    private RedisInfo redisInfo;

    @Test
    public void test() {
        System.out.println(redisInfo);
    }
}
