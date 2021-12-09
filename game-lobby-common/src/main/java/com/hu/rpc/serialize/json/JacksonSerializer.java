package com.hu.rpc.serialize.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hu.rpc.serialize.Serializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;


import java.nio.charset.StandardCharsets;

/**
 * @author hu
 * @date 2021/12/6
 */
@Slf4j
public class JacksonSerializer implements Serializer {

    @Bean
    private static ObjectMapper getMapper() {
        return new ObjectMapper();
    }

    @Override
    public <T> byte[] serialize(T obj) {
        byte[] result;
        String string = null;
        try {
            string = JacksonSerializer.getMapper().writerWithDefaultPrettyPrinter().
                    writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        assert string != null;
        result = string.getBytes(StandardCharsets.UTF_8);
        return result;
    }

    @Override
    public <T> T deserialize(byte[] bytes, Class<T> clazz) {
        String s = new String(bytes);
        T t = null;
        try {
            t = JacksonSerializer.getMapper().readValue(s, clazz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return t;
    }
}
