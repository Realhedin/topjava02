package ru.javawebinar.topjava.web.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Dmitrii on 4/17/15.
 */
@Component
public class StringToLocalDateTimeConverter implements Converter<String, LocalDateTime> {

    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm";

    @Override
    public LocalDateTime convert(final String source) {
        return LocalDateTime.parse(source, DateTimeFormatter.ofPattern(DATE_FORMAT));
    }
}
