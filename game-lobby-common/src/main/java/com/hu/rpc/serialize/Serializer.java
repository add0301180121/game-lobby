package com.hu.rpc.serialize;

/**
 * @author hu
 * @date 2021/12/6
 */
public interface Serializer {
    /**
     * 序列化
     *
     * @param obj 对象
     * @return 字节数组
     */
    <T> byte[] serialize(T obj);

    /**
     * 反序列化
     *
     * @param bytes 字节数组
     * @param clazz 对象的classInfo对象
     * @param <T>   对象类的类型
     * @return 对象
     */
    <T> T deserialize(byte[] bytes, Class<T> clazz);
}
