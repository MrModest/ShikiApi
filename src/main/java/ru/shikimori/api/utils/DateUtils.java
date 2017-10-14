package ru.shikimori.api.utils;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    private DateUtils(){}

    public static LocalDateTime formatDateTimeFromString(String str){
        if (StringUtils.isBlank(str)){ return null; }

        try {
            return LocalDateTime.parse(str, DateTimeFormatter.ISO_OFFSET_DATE_TIME); //.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
        }
        catch (Exception ex){
            return null;
        }
    }

    public static LocalDate formatDateFromString(String str){
        if (StringUtils.isBlank(str)){ return null; }

        try {
            return LocalDate.parse(str, DateTimeFormatter.ISO_LOCAL_DATE); //.ofPattern("yyyy-MM-dd")
        }
        catch (Exception ex){
            return null;
        }
    }

}
