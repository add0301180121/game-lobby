package com.hu.rpc.serialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * 序列化的类
 *
 * @author hu
 * @date 2021/12/5
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {
    private static final long serialVersionUID = -9082489413546254231L;
    private transient String userName;
    private String password;
    private static String id;
}
