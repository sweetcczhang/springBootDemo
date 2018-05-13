package cn.bupt.zcc.util;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.lang.Nullable;

/**
 * 实现redis值的序列化
 * Created by 张城城 on 2018/5/12.
 */
public class RedisObjectSerializer implements RedisSerializer<Object> {

    private Converter<Object,byte[]> serializer = new SerializingConverter();
    private Converter<byte[],Object> deserializer = new DeserializingConverter();
    static final byte[] EMPTY_ARRAY = new byte[0];
    @Override
    public byte[] serialize(@Nullable Object o) throws SerializationException {
        if (o==null)
            return EMPTY_ARRAY;
        try {
            return serializer.convert(o);
        }catch (Exception ex){
            return EMPTY_ARRAY;
        }
    }

    @Override
    public Object deserialize(@Nullable byte[] bytes) throws SerializationException {
        if (isEmpty(bytes))
            return null;
        try {
            return deserializer.convert(bytes);
        }catch (Exception ex){
            throw new SerializationException("Cannot deserialize",ex);
        }
    }
    private boolean isEmpty(byte[] data){
        return (data==null || data.length==0);
    }
}
