package ru.javawebinar.topjava.util;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import ru.javawebinar.topjava.util.mapper.HibernateAwareObjectMapper;

import java.io.IOException;

/**
 * User: gkislin
 * Date: 30.04.2014
 */
public class JsonUtil {
    private static final ObjectMapper mapper = new HibernateAwareObjectMapper();

    public static <T> MappingIterator<T> readValues(String json, Class<T> clazz) throws IOException {
        ObjectReader reader = mapper.reader(clazz);
        return reader.readValues(json);
    }

    public static <T> T readValue(String json, Class<T> clazz) throws IOException {
        return mapper.readValue(json, clazz);
    }

    public static <T> String writeValue(T obj) throws IOException {
        return mapper.writeValueAsString(obj);
    }
}
