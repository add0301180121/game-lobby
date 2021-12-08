package com.hu.rpc.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
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
public class CuratorConfigTest {

    @Autowired
    private CuratorConfig config;

    @Test
    public void test() throws Exception {
        System.out.println(config);
        CuratorFramework client = config.zkClient();
        client.create().forPath("/path");
        client.delete().forPath("/path");
    }
}