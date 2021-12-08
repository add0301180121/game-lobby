package com.hu.rpc.serialize;

import java.util.Optional;
import java.util.ServiceLoader;
import java.util.stream.StreamSupport;

/**
 * @author hu
 * @date 2021/12/6
 */
@Deprecated
public class OptionalSerializer {
    public static Serializer getSerializer(Class clazz) throws InstantiationException, IllegalAccessException {
        ServiceLoader<Serializer> spi = ServiceLoader.load(Serializer.class);
        final Optional<Serializer> serializer = StreamSupport.stream(spi.spliterator(), false)
                .findFirst();
        return serializer.orElse((Serializer) clazz.newInstance());
    }
}
