package com.hu.rpc.registry;

import com.hu.rpc.remoting.dto.RpcRequest;

import java.net.InetSocketAddress;

/**
 * 服务发现
 *
 * @author hu
 * @date 2021/12/6
 */
public interface ServiceDiscovery {
    /**
     * 通过服务名
     * @param rpcRequest
     * @return
     */
    InetSocketAddress discoveryService(RpcRequest rpcRequest);
}
