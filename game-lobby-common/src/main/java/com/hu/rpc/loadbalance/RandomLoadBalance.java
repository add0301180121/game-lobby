package com.hu.rpc.loadbalance;

import com.hu.rpc.remoting.dto.RpcRequest;

import java.util.List;
import java.util.Random;

/**
 * 随机选取 用Random类
 *
 * @author hu
 * @date 2021/12/8
 */
public class RandomLoadBalance extends AbstractLoadBalance {
    @Override
    protected String selectServiceAddress(List<String> serviceAddress, RpcRequest rpcRequest) {
        Random random = new Random();
        //获取serviceAddress长度n,在[0,n]的范围下
        return serviceAddress.get(random.nextInt(serviceAddress.size()));
    }
}
