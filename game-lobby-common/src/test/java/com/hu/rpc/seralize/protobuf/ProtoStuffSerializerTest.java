package com.hu.rpc.seralize.protobuf;

import com.hu.rpc.config.RpcConfig;
import com.hu.rpc.seralize.Person;
import com.hu.rpc.seralize.Student;
import com.hu.rpc.serialize.protobuf.ProtoStuffSerializer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

/**
 * @author hu
 * @date 2021/12/6
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RpcConfig.class)
public class ProtoStuffSerializerTest {

    @Autowired
    private ProtoStuffSerializer protoStuffSerializer;

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

        byte[] serialize = protoStuffSerializer.serialize(person);
        Person deserialize = protoStuffSerializer.deserialize(serialize, Person.class);
        System.out.println(serialize.length);
    }
}
