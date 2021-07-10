///*
//ID: aaroh.s1
//TASK: beads
//LANG: JAVA
//*/
//
//package com.company;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class beads {
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new FileReader("beads.in"));
//        int n = Integer.parseInt(br.readLine());
//        List<Character> bead = new ArrayList<>();
//        String s;
//        while(bead.size()<n){
//            s = br.readLine();
//            char[] temp = s.toCharArray();
//            for(char c: temp){
//                bead.add(c);
//            }
//        }
//        List<Character> beads = new ArrayList<Character>(bead);
//        for(int i = bead.size()-1; i>=0;i--){
//            beads.add(bead.get(i));
//        }
//        int longest = 0;
//        for(int i = 0; i<beads.size()-1; i++){
//            int firstLen = 0;
//            int secLen = 0;
//            int x = i;
//            int counter = 0;
//            while((beads.get(x) == beads.get(i) || beads.get(x) == 'w') && counter<beads.size()-1){
//                counter++;
//                firstLen++;
//                --x;
//            }
//            counter = 0;
//            int y = i+1;
//            while((beads.get(y) == beads.get(i+1) || beads.get(y) == 'w') && counter<beads.size()-1){
//                counter++;
//                secLen++;
//                ++y;
//            }
//            if(firstLen+secLen>longest)
//                longest = firstLen+secLen;
//        }
//        br.close();
//        BufferedWriter writer = new BufferedWriter(new FileWriter("beads.out"));
//        if(longest>=beads.size())
//            writer.write(String.valueOf(beads.size()) + "\n");
//        else
//            writer.write(String.valueOf(longest) + "\n");
//        writer.close();
//
//    }
//
//}
