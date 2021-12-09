package com.hu.rpc.serialize.protobuf;


import com.hu.rpc.remoting.dto.RpcRequest;
import com.hu.rpc.serialize.Person;
import com.hu.rpc.serialize.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author hu
 * @date 2021/12/6
 */
@Slf4j
public class ProtoStuffSerializerTest {

    private ProtoStuffSerializer protoStuffSerializer = new ProtoStuffSerializer();

    @Test
    public void test() {
        int[] a = new int[1];
        a[0] = 12;
        Person person = new Person();
        person.setId(1);
        person.setAge(12);
        person.setName("123");
        person.setRemark("12");
        person.setArray(a);
        Student student = new Student();
        student.setUserName("h");
        student.setPassword("123");
        ArrayList<String> strings = new ArrayList<>();
        strings.add("12");
        strings.add("1");
        person.setStudent(student);
        person.setMore(strings);

        RpcRequest target = RpcRequest.builder().methodName("hello")
                .parameters(new Object[]{"sayhelooloo", "sayhelooloosayhelooloo"})
                .className("github.javaguide.HelloService")
                .paramTypes(new Class<?>[]{String.class, String.class})
                .requestId(UUID.randomUUID().toString())
                .version("version1")
                .build();

        byte[] serialize = protoStuffSerializer.serialize(person);
        Person deserialize = protoStuffSerializer.deserialize(serialize, Person.class);
        System.out.println(serialize.length);

        byte[] serialize2 = protoStuffSerializer.serialize(target);
        RpcRequest deserialize2 = protoStuffSerializer.deserialize(serialize2, RpcRequest.class);
        System.out.println(serialize2.length);
    }
}
