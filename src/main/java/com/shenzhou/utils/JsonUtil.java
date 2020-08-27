package com.shenzhou.utils;


import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import java.io.IOException;

public class JsonUtil {


    public static String writeValueAsString(Object o) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS);
        try {
            return mapper.writeValueAsString(o);
        } catch (IOException e) {
        }
        return null;
    }

    public static <T> T readObject(String json, Class<T> clazz) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
        try {
            return mapper.readValue(json, clazz);
        } catch (IOException e) {
        }
        return null;
    }
}
