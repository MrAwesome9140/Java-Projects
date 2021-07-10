package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    int[] staticList1 = {101,105,115,125,145,165,175,185,195,225,235,275,305,315,325,335,345,355,375,385};
	    int[] staticList2 = {110,120,130,140,150,160,170,180,190,200,210,220,230,240,250,270,280,320,350,400};

        Array stats1 = new Array(staticList1, "List #1");
        Array stats2 = new Array(staticList2, "List #2");
        Array merged = new Array("Merged List");

        merged.fullSort(stats1,stats2);
        merged.display();

    }
}

class Array{
    private ArrayList<Integer> list;
    private int size;
    private String listName;

    public Array(String ln){
        list = new ArrayList<>();
        size = 0;
        listName = ln;
    }

    public Array(int[] jsArray, String ln){
        list = new ArrayList<>();
        size = jsArray.length;
        listName = ln;
        for(int i: jsArray){
            list.add(i);
        }
    }

    public void display(){
        System.out.println("\n" + listName + ":\n");
        System.out.println(list + "\n");
    }

//    public int[] conToArray(){
//        int[] replace = new int[list.size()];
//        for(int i = 0; i<replace.length;i++){
//            replace[i] = list.get(i);
//        }
//        return replace;
//    }
//
//    public void fromArray(int[] rand){
//        if(rand.length>0) {
//            list.clear();
//            for (int i = 0; i < rand.length; i++) {
//                list.add(rand[i]);
//            }
//        }
//    }

    public void fullSort(Array a, Array b){
        int[] temp = mergeArrays(a,b);
        temp = mergeSort(temp,temp.length);
        if(temp.length>0) {
            list.clear();
            for (int i = 0; i < temp.length; i++) {
                list.add(temp[i]);
            }
        }
    }

    public int[] mergeArrays(Array a1, Array a2){
        for(int i:a1.list){
            list.add(i);
        }
        for(int i:a2.list){
            list.add(i);
        }
        int[] temp = new int[list.size()];
        for(int i = 0; i<list.size();i++){
            temp[i] = list.get(i);
        }
        return temp;
    }

    public static int[] mergeSort(int[] nums, int n){
        if(n<2){
            return nums;
        }
        int mid = n/2;
        int[] first = new int[mid];
        int[] last = new int[n-mid];

        for(int i = 0;i<mid; i++){
            first[i] = nums[i];
        }
        for(int i = mid; i<n; i++) {
            last[i-mid] = nums[i];
        }

        mergeSort(first,mid);
        mergeSort(last,n-mid);

        merge(nums,first,last,mid,n-mid);

        return nums;
    }

    public static void merge(int[] a, int[] l, int[] r, int left, int right){
        int i = 0, j = 0, k = 0;
        while(i<left && j<right){
            if(l[i]<r[j]){
                a[k++] = l[i++];
            }
            else{
                a[k++] = r[j++];
            }
        }
        while(i<left){
            a[k++] = l[i++];
        }
        while(j<right){
            a[k++] = r[j++];
        }
    }
}
