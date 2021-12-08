package com.hu.rpc.remoting.dto;

import lombok.*;

import java.io.Serializable;

/**
 * 数据传输对象 response
 *
 * @author hu
 * @date 2021/12/8
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class RpcResponse implements Serializable {
    private static final long serialVersionUID = 1739465881378422195L;
    private String requestId;
    private String error;
    private Object result;
}
