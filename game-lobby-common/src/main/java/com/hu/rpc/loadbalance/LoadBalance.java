package com.hu.rpc.loadbalance;

import com.hu.rpc.remoting.dto.RpcRequest;

import java.util.List;

/**
 * @author hu
 * @date 2021/12/8
 */
public interface LoadBalance {
    /**
     * 从一堆服务地址中选择其中一个
     * @param serviceAddress 服务地址表
     * @param rpcRequest 请求体
     * @return 选中的地址
     */
    String chooseServiceAddress(List<String> serviceAddress, RpcRequest rpcRequest);
}
