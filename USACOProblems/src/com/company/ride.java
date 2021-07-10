/*
ID: aaroh.s1
TASK: ride
LANG: JAVA
*/

package com.company;
import java.lang.*;
import java.util.*;
import java.io.*;

public class ride {

    public static void main(String[] args) throws IOException{

        BufferedReader bf = new BufferedReader(new FileReader(new File("ride.in")));
        String[] lines = new String[2];
        String next = "";
        int counter = 0;
        while((next = bf.readLine()) != null){
            lines[counter] = next;
            counter++;
        }

        char[] comet = lines[0].toCharArray();
        char[] group = lines[1].toCharArray();

        int cometSum = 1;
        int groupSum = 1;

        for(char c: comet){
            cometSum *= (int)c-64;
        }
        for(char c:group){
            groupSum *= (int)c-64;
        }

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File("ride.out"))));

        if((cometSum%47)==(groupSum%47)) pw.println("GO");
        else pw.println("STAY");

        pw.close();
        bf.close();

    }
}
