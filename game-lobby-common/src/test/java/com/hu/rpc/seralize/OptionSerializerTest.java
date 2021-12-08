package com.hu.rpc.seralize;

import com.hu.rpc.serialize.OptionalSerializer;
import com.hu.rpc.serialize.Serializer;
import com.hu.rpc.serialize.json.JacksonSerializer;
import com.hu.rpc.serialize.protobuf.ProtoStuffSerializer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.stream.StreamSupport;

/**
 * @author hu
 * @date 2021/12/6
 */
public class OptionSerializerTest {

    @Test
    public void test() throws InstantiationException, IllegalAccessException {
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

        Serializer serializer = OptionalSerializer.getSerializer(JacksonSerializer.class);
        byte[] serialize = serializer.serialize(person);
        System.out.println(Arrays.toString(serialize));
        System.out.println(serialize.length);
    }
}
