package com.company;

import java.io.*;

public class milk2 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new FileReader(new File("milk2.in")));
        int lines = Integer.parseInt(bf.readLine());
        int[][] vals = new int[lines][2];
        for(int i = 0;i<lines;i++){
            String temp = bf.readLine();
            String[] temps = temp.split(" ");
            vals[i][0] = Integer.parseInt(temps[0]);
            vals[i][1] = Integer.parseInt(temps[1]);
        }

        int longest = 0;
        int shortest = 0;

        for(int i = 0;i<lines;i++){
            for(int k = 0;k<lines;k++){
                if(k!=i && vals[k][1]>vals[i][0] && vals[k][0]<vals[i][1]){
                    if(vals[k][1]-vals[i][0]>longest){
                        longest = vals[k][1]-vals[i][0];
                    }
                }
                else if(k!=i && vals[k][0]>vals[i][1]){
                    if(vals[k][0]-vals[i][1]>shortest){
                        shortest = vals[k][0]-vals[i][1];
                    }
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("milk2.out")));
        bw.write(String.valueOf(longest) + " " + String.valueOf(shortest));
        bw.flush();
        bw.close();

    }

}
