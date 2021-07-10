package com.company;

public class Main {

    public static void main(String[] args) {
	    System.out.println(hailstoneLength(5));
	    System.out.println(propLong(9));
    }

    public static int hailstoneLength(int n){
        if(n==1)
            return 1;
        int counter = 1;
        while(n!=1){
            if(n%2!=0)
                n = 3*n+1;
            else
                n/=2;
            counter++;
        }
        return counter;
    }

    public static boolean isLongSeq(int n){
        return hailstoneLength(n)>n;
    }

    public static double propLong(int n){
        int longs = 0;
        for(int i = 1; i<=n; i++)
            if(isLongSeq(i))
                longs++;
        return (double)longs/n;
    }

}
