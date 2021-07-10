package com.company;

import java.util.*;
import java.awt.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Integer[] j = {2,5,9,6,3,70,10};
//        Integer[] sorted = insertionSort(j);
//        for(int i: sorted){
//            System.out.println(i);
//        }
        //quickSort(j, j.length/2, j.length-1);
        Arrays.sort(j);
        for(int i: j){
            System.out.println(i);
        }
    }

    public static Integer[] insertionSort(Integer[] nums){
        for(int i = 1; i<nums.length; i++){
            int val = nums[i];
            int j = i-1;
            while(j>=0 && val<nums[j]){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = val;
        }
        return nums;
    }

    public static Integer[] quickSort(Integer[] nums, int m, int l){
        ArrayList<Integer> numList = new ArrayList<Integer>(Arrays.asList(nums));
        int pivot = numList.get(l), leftam = 0;
        for(int x = l-1; x-leftam>=0; x--){
            if(pivot < nums[x-leftam]){
                int temp = numList.get(x-leftam);
                numList.remove(x-leftam);
                numList.add(numList.indexOf(pivot)+1, temp);
            }
            else{
                leftam++;
            }
        }
        int[] lower = new int[numList.indexOf(pivot)+1];
        int[] higher = new int[numList.size()-numList.indexOf(pivot)-1];
        return nums;
    }

    public static void swap(ArrayList<Integer> arr, int n1, int n2){
        int temp = arr.get(n1);
        arr.set(n1,arr.get(n2));
        arr.set(n2,temp);
    }
}
