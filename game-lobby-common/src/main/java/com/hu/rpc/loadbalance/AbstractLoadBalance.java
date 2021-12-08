package com.hu.rpc.loadbalance;

import com.hu.rpc.remoting.dto.RpcRequest;

import java.util.List;

/**
 * @author hu
 * @date 2021/12/8
 */
public abstract class AbstractLoadBalance implements LoadBalance {
    @Override
    public String chooseServiceAddress(List<String> serviceAddress, RpcRequest rpcRequest) {
        if (null == serviceAddress || serviceAddress.size() == 0) {
            return null;
        }
        if (serviceAddress.size() == 1) {
            return serviceAddress.get(0);
        }
        return selectServiceAddress(serviceAddress, rpcRequest);
    }

    /**
     * 子类重写
     *
     * @param serviceAddress
     * @param rpcRequest
     * @return
     */
    protected abstract String selectServiceAddress(List<String> serviceAddress, RpcRequest rpcRequest);
}
