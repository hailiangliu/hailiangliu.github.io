package com.test;

public class Gong {
    public static void main(String args[]){

        long currentCount = 10;

        long increaseCount = 2;

        long currentMonth = 1;

        long totalMonth = 8;

        long result = calcStaffCount(currentCount, increaseCount , currentMonth , totalMonth );

        System.out.println("第"+totalMonth+"个月员工数："+result );

    }

    public static long calcStaffCount(long currentCount, long increaseCount, long currentMonth, long totalMonth){

        if(currentMonth>=totalMonth){

            return currentCount;

        }

        currentCount = currentCount +increaseCount;

        currentMonth++;

        return calcStaffCount(currentCount, increaseCount, currentMonth, totalMonth);

    }
}
