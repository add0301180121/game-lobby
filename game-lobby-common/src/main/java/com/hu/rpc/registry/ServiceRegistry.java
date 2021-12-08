package com.hu.rpc.registry;

import java.net.InetSocketAddress;

/**
 * 服务注册
 *
 * @author hu
 * @date 2021/12/6
 */
public interface ServiceRegistry {
    /**
     * 注册服务
     * @param rpcServiceName 服务名
     * @param inetSocketAddress 服务端的ip port
     */
    void registerService(String rpcServiceName, InetSocketAddress inetSocketAddress);
}
