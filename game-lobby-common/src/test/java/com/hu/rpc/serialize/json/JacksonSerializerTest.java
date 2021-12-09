package com.hu.rpc.serialize.json;


import com.hu.rpc.serialize.Person;
import com.hu.rpc.serialize.Student;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;


import java.util.ArrayList;

/**
 * @author hu
 * @date 2021/12/6
 */
@Slf4j
public class JacksonSerializerTest {

    private JacksonSerializer jacksonSerializer = new JacksonSerializer();

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

        byte[] serialize = jacksonSerializer.serialize(person);
        Person deserialize = jacksonSerializer.deserialize(serialize, Person.class);
        System.out.println(serialize.length);
    }
}
