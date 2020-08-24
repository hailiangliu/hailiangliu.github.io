package com.demo.joda;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;

import java.util.Date;

public class JodaTest3 {

    //标准UTC时间：2014-11-04T09:22:54.876Z
    public static Date convertUTC2Date(String utcDate) {
        try {
            DateTime date = DateTime.parse(utcDate, DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
            return date.toDate();
        } catch (Exception e) {
            return null;
        }
    }

    public static String convertDate2UTC(Date javaDate) {
        DateTime dateTime = new DateTime(javaDate, DateTimeZone.UTC);
        return dateTime.toString();
    }

    public static String convertDate2LocalByDateFormat(Date javaDate, String format) {
        DateTime dateTime = new DateTime(javaDate);
        return dateTime.toString(format);
    }
    public static void main(String[] args) {
        System.out.println(JodaTest3.convertUTC2Date("2014-11-04T09:22:54.876Z")); // Tue Nov 04 17:22:54 CST 2014
        System.out.println(JodaTest3.convertDate2UTC(new Date()));
        System.out.println(JodaTest3.convertDate2LocalByDateFormat(new Date(),"yyyy-MM-dd HH:mm:ss"));

    }
}
