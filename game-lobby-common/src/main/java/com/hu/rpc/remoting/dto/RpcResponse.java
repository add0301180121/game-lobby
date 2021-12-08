package com.hu.rpc.remoting.dto;

import lombok.*;

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
public class RpcResponse {
    private String requestId;
    private String error;
    private Object result;
}
