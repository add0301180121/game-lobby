package com.hu.rpc.seralize.com.hu.rpc.config.info;

import com.hu.rpc.config.RpcConfig;
import com.hu.rpc.config.info.CuratorInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author hu
 * @date 2021/12/6
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RpcConfig.class)
public class CuratorInfoTest {

    @Resource
    private CuratorInfo curatorInfo;

    @Test
    public void test() {
        System.out.println(curatorInfo);
    }
}
