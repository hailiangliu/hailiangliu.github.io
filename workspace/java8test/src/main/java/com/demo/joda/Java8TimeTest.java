package com.demo.joda;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Set;

public class Java8TimeTest {
    public static void main(String[] args) {
        // 使用java.time.LocalDate测试，当前日期为：2020-08-24
        LocalDate localDate = LocalDate.now(); // 2020-08-24
        System.out.println(localDate); //2020-08-24
        System.out.println(localDate.getYear() + "," + localDate.getMonthValue() + "," + localDate.getDayOfMonth()); //2020,8,24

        LocalDate localDate2 = LocalDate.of(2017, 3, 3);
        System.out.println(localDate2); // 2017-03-03

        LocalDate localDate3 = LocalDate.of(2010, 3, 25);
        MonthDay monthDay = MonthDay.of(localDate3.getMonth(), localDate3.getDayOfMonth());
        MonthDay monthDay1 = MonthDay.from(LocalDate.of(2011, 3, 25));
        if (monthDay.equals(monthDay1)) {
            System.out.println("equals"); // 输出相等，MonthDay, 只记录月、日，无年，因此相等
        } else {
            System.out.println("not equals");
        }

        LocalTime time = LocalTime.now();
        System.out.println(time); // 只获取时间：10:58:52.714

        LocalTime localTime = time.plusHours(3).plusMinutes(20);
        System.out.println(localTime); // 14:18:52.714， 对档期啊那时间+3小时，+20分钟



        // -- 直接使用plus方法，指定unit
        LocalDate now = LocalDate.now(); // 2020-08-24
        System.out.println(now.plus(2, ChronoUnit.WEEKS)); // 当前时间+2周 ：2020-09-07

        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock.millis()); // 1598238463052

        // 获取所有市区
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.stream().forEach(System.out::println); // 无排序的 类似： Asia/Shanghai

        ZoneId zone = ZoneId.of("Asia/Shanghai");
        LocalTime now1 = LocalTime.now();


    }
}
