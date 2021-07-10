package com.company;

public class Main {

    public static void main(String[] args) {
        String qqq = "Haleakala";
        System.out.println(qqq.substring(2,6));
    }

    public Boolean checkForPalindrome(String pal){
        String reverse = new StringBuffer(pal).reverse().toString();
        if(reverse.equals(pal)){
            return true;
        }
        else{
            return false;
        }
    }
}
