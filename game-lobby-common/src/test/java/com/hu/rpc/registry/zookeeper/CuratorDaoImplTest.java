package com.hu.rpc.registry.zookeeper;

import com.hu.rpc.config.RpcConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author hu
 * @date 2021/12/7
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RpcConfig.class)
public class CuratorDaoImplTest {

    @Autowired
    private CuratorDaoImpl curatorDao;

    @Test
    public void test() {
        curatorDao.createPersistentNode("/aaa");
    }
}
