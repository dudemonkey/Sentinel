package com.alibaba.csp.sentinel.dashboard.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author LuHou
 * @Date: 2021/6/4 6:20 下午
 * @Version 1.0.0
 * Description ：
 */
public class JSONUtils {

    public static <T> String toJSONString(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return new ObjectMapper()
                .getTypeFactory()
                .constructParametricType(collectionClass, elementClasses);
    }

    public static <T> List<T> parseObject(Class<T> clazz, String string) {
        JavaType javaType = getCollectionType(ArrayList.class, clazz);
        try {
            return (List<T>) new ObjectMapper().readValue(string, javaType);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

}
