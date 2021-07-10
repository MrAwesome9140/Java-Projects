package com.company;

import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new File("gymnastics.in"));
        String i = sc.nextLine();
        String[] vals = i.split(" ");
        int lines = Integer.parseInt(vals[0]);
        int cows = Integer.parseInt(vals[1]);
        int[][] cowers = new int[lines][cows];
        int rows = 0;
        int cols = 0;
        while(sc.hasNextLine()){
            cols = 0;
            String[] temp = sc.nextLine().split(" ");
            for(String s: temp){
                int j = Integer.parseInt(s);
                cowers[rows][cols] = j;
                cols++;
            }
            rows++;
        }


        ArrayList<boolean[]> go = new ArrayList<>();

        for(int x = 1;x<=cows;x++){
            for(int k = 1; k<=cows;k++) {
                boolean[] temps = new boolean[lines];
                int t = 0;
                if (k == x) ;
                else{
                    boolean temp = false;
                    for (int row = 0; row < lines; row++) {
                        for (int col = 0; col < cows; col++) {
                            if (cowers[row][col] == x) {
                                boolean b = false;
                                for (int h = col + 1; h < cows; h++) {
                                    if (cowers[row][h] == k) {
                                        b = true;
                                    }
                                }
                                temps[t] = b;
                            }
                        }
                        t++;
                    }
                    go.add(temps);
                }

            }
        }
        int pairs = 0;
        for(boolean[] b: go){
            boolean temp = true;
            for(boolean h:b){
                if(h);
                else{
                    temp = false;
                }
            }
            if(temp)
                pairs++;
        }

        FileWriter fw = new FileWriter(new File("gymnastics.out"));
        fw.write(String.valueOf(pairs));
        fw.flush();
        fw.close();
    }
}
