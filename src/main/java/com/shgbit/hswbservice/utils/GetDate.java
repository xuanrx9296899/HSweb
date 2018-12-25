package com.shgbit.hswbservice.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author xuanrxup
 * @date 2018/12/19  19:11
 */
public class GetDate {
    public static String getDate(LocalDateTime time){

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime time=LocalDateTime.now();
        String localTime=dateTimeFormatter.format(time);
        return localTime;
    }

}
