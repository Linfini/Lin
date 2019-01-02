package com.zaki.timeApiTest;

import org.junit.Test;

import java.sql.SQLOutput;
import java.time.*;

public class JDK8TimeTest {

    //Clock
    @Test
    public void  testClock(){
        Clock utcClock=Clock.systemUTC();
        System.out.println(utcClock);
        System.out.println(Clock.systemDefaultZone());
        Clock c5 = Clock.offset(utcClock, Duration.ofSeconds(2)); //相对于系统默认时钟两秒的时钟
    }

    //Instance
    @Test
    public void testInstant(){
        //默认时区
        System.out.println(Instant.now());
        //到java纪元的秒时间
        System.out.println(Instant.now().getEpochSecond());
        //到java纪元的毫秒时间
        System.out.println(Instant.now().toEpochMilli());
        System.out.println(System.currentTimeMillis());

        Instant now = Instant.now(Clock.fixed(Instant.now(), ZoneId.systemDefault()));
        System.out.println(now);
    }

    //LocalDateTime LocalDate LocalTime
    @Test
    public void testLocalDateOrTime(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDateTime localDateTime = LocalDateTime.of(2018, 12, 1, 0, 0);
        int value = localDateTime.getMonth().getValue();
        System.out.println(value);
    }
}
