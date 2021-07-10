package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        System.out.println((int)(Math.random()*10)+1);
        System.out.println((int)(Math.random()*10)+1);
        System.out.println((int)(Math.random()*10)+1);
        System.out.println((int)(Math.random()*10)+1);
        System.out.println((int)(Math.random()*10)+1);



    }

//    public void updateCosts(double piano, double voice, double reg){
//        for(Lesson s:lessonList){
//            if(s.getType().equals("piano"))
//                s.setCost(s.getCost()+piano);
//            else if(s.getType().equals("voice"))
//                s.setCost(s.getCost()+voice);
//            else
//                s.setCost(s.getCost()+reg);
//        }
//    }
//
//    public double getDiscountedLessonCost(double discount){
//        ArrayList<Integer> valid = new ArrayList<>();
//        for(int i = 0; i<lessonList.size(); i++){
//            if(lessonList.get(i).getType().equals("piano") && lessonList.get(i).isRegEarly())
//                valid.add(i);
//        }
//        int random = (int)(Math.random()*valid.size());
//        lessonList.get(valid.get(random)).setCost(lessonList.get(valid.get(random)).getCost()-discount);
//        return lessonList.get(valid.get(random)).getCost();
//    }

    static int getInt(){
        return (int)(Math.random()*20-9);
    }

    public static double analyzeInts(int max, int n){
        int works = 0;
        for(int i = 0; i<n; i++){
            int temp = getInt();
            if(temp>0 && temp<max && temp%3==0)
                works++;
        }
        return (double)works/n;
    }



}
