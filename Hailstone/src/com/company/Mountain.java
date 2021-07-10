package com.company;

public class Mountain {

    public static void main(String[] args) {

    }

    public static int getPeakIndex(int[] array){
        for(int i = 1; i<array.length-1; i++){
            if(array[i-1]<array[i] && array[i+1]<array[i])
                return i;
        }
        return -1;
    }

    public static boolean isMountain(int[] array){
        int peak = getPeakIndex(array);
        if(peak==-1)
            return false;
        return isIncreasing(array, peak) && isDecreasing(array, peak);
    }

}
