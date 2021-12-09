package com.hu.rpc.remoting.dto;

import lombok.*;

import java.io.Serializable;

/**
 * 数据传输对象 request
 * 类的全路径 方法名 参数类型 参数列表
 *
 * @author hu
 * @date 2021/12/8
 */
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RpcRequest implements Serializable {
    private static final long serialVersionUID = -1125313125202599423L;
    private String requestId;
    private String className;
    private String methodName;
    private Object[] parameters;
    private Class<?>[] paramTypes;
    private String version;
}
