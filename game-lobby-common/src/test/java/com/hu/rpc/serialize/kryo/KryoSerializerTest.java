package com.hu.rpc.serialize.kryo;

import com.hu.rpc.remoting.dto.RpcRequest;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.UUID;

/**
 * @author hu
 * @date 2021/12/9
 */
public class KryoSerializerTest {

    @Test
    public void test() {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setRequestId("111");
        rpcRequest.setClassName("com.hu");
        rpcRequest.setMethodName("add");
        rpcRequest.setVersion("1.0");

        RpcRequest target = RpcRequest.builder().methodName("hello")
                .parameters(new Object[]{"sayhelooloo", "sayhelooloosayhelooloo"})
                .className("github.javaguide.HelloService")
                .paramTypes(new Class<?>[]{String.class, String.class})
                .requestId(UUID.randomUUID().toString())
                .version("version1")
                .build();

        KryoSerializer kryoSerializer = new KryoSerializer();
        byte[] serialize = kryoSerializer.serialize(target);
        System.out.println(Arrays.toString(serialize));
        System.out.println(serialize.length);
    }

}
