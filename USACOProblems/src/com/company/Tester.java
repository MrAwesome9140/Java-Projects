package com.company;

public class Tester {

    public static void main(String[] args){
        System.out.println(val(11.0,11.0));
        System.out.println(val(13L,13L));
        System.out.println(hi(true, true));
        System.out.println(hi(true, false));
        System.out.println(hi(false, true));
        System.out.println(hi(false, false));
    }

    static int val(Object a, Object b){
        System.out.println(a + ", " + b);
        if(a==b)
            return 33;
        return 77;
    }

    static boolean hi(Boolean a, Boolean b){
        return a || !b && !a || b;
    }

}
