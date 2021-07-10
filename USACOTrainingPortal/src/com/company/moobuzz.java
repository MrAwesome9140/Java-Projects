package com.company;

import java.io.*;
import java.util.*;

public class moobuzz {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("moobuzz.in")));

        int num = Integer.parseInt(br.readLine());
        br.close();

        int counter = 0;

        int currentNum = 1;
        while(counter<num){
            if(currentNum%3!=0 && currentNum%5!=0 && currentNum%15 != 0)
                counter++;
            if(counter<num)
                currentNum++;
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("moobuzz.out")));
        PrintWriter pw = new PrintWriter(new File("moobuzz.out"));
        pw.append(String.valueOf(currentNum)+"\n");
        pw.close();

    }

}
