package com.hu.rpc.serialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author hu
 * @date 2021/12/5
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {
    private static final long serialVersionUID = 1988771366677080L;
    private Integer id;
    private String name;
    private String remark;
    private Integer age;
    private int[] array;
    private Student student;
    private List<String> more;
}
