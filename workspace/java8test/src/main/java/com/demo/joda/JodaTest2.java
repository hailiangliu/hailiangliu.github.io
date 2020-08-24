package com.demo.joda;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public class JodaTest2 {
    public static void main(String[] args) {

        DateTime today = new DateTime(); // 当前时间为 2020-08-24

        DateTime tomorrow = today.plusDays(1);

        System.out.println(today.toString("yyyy-MM-dd"));  //2020-08-24
        System.out.println(tomorrow.toString("yyyy-MM-dd"));//2020-08-25

        DateTime d1 = today.withDayOfMonth(1);
        System.out.println(d1.toString("yyyy-MM-dd")); //2020-08-01


        LocalDate localDate = new LocalDate(); // 当前时区
        System.out.println(localDate);// 2020-08-24

        // 计算 距离当前时间 后面三个月 所在月的第一天的日志
        LocalDate localdate1 = localDate.plusMonths(3).dayOfMonth().withMinimumValue();
        System.out.println(localdate1); // 2020-11-01
        localdate1 = localDate.plusMonths(3).dayOfMonth().withMaximumValue();
        System.out.println(localdate1); //2020-11-30, 不用考虑最后一天是30还是31

        // 计算两年前第三个月最后一天的日期
        DateTime dateTime = new DateTime();
        DateTime dateTime1 = dateTime.minusYears(2).monthOfYear().setCopy(3).dayOfMonth().withMaximumValue();
        System.out.println(dateTime1.toString("yyyy-MM-dd")); // 2018-03-31

    }
}
