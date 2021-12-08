package com.hu.login.dao.redis;

import com.hu.login.config.DataConfig;
import com.hu.login.config.info.JdbcInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
public class RedisDaoImplTest {

    @Autowired
    private RedisDaoImpl redisDao;

    @Test
    public void test() {
        redisDao.set("c", "b");
        redisDao.set("aa", "bb", 200);
        System.out.println("c的value:" + redisDao.get("c"));
        System.out.println("aa过期时间：" + redisDao.getExpire("aa"));
        System.out.println(redisDao.existKey("c"));
        System.out.println(redisDao.expire("c", 2000));
        System.out.println(redisDao.getExpire("c"));
        redisDao.del("c","aa");
    }

}
