package com.test;

public class Main {

    public static void main(String[] args) {

        System.out.println(Main.find1TimesNumber(new int[]{1,1,0,2,3,3}));
        System.out.println(Main.find1TimesNumber(new int[]{1,1,2,2,3,3}));
        System.out.println(Main.find1TimesNumber(new int[]{-9,-1,2,2,3,3}));

    }

    public static int find1TimesNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            boolean hasSame = false;
            for (int j = 0; j < nums.length; j++) {
                if(i==j){
                    continue;
                }
                int end = nums[j];
                if (start == end) {
                    hasSame = true;
                    break;
                }
            }
            if(hasSame){
                continue;
            }
            return start;
        }
        return -1;
    }

}
