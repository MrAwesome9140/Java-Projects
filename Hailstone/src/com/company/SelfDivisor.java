package com.company;

import java.util.ArrayList;

public class SelfDivisor {

    public static void main(String[] args) {
        System.out.println(isSelfDivisor(127));
        for(int i: firstNumSelfDivisors(10, 3)){
            System.out.println(i);
        }
    }

    static boolean isSelfDivisor(int number){
        char[] temp = String.valueOf(number).toCharArray();
        for(int i = 0; i<temp.length; i++){
            int digit = Integer.parseInt(String.valueOf(temp[i]));
            if(digit==0 || number%digit!=0)
                return false;
        }
        return true;
    }

    static int[] firstNumSelfDivisors(int start, int num){
        int[] nums = new int[num];
        int found = 0;
        while(found<num){
            if(isSelfDivisor(start)) {
                nums[found] = start;
                found++;
            }
            start++;
        }
        return nums;
    }

}
