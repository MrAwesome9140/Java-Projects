/*
ID: aaroh.s1
PROG: ride
LANG: JAVA
*/

package com.company;
import java.lang.*;
import java.util.*;
import java.io.*;

public class YourRideIsHere {

    public static void main(String[] args) throws IOException{

        BufferedReader bf = new BufferedReader(new FileReader(new File("ride.in")));
        String[] lines = new String[2];
        String next = "";
        int counter = 0;
        while((next = bf.readLine())!=""){
            lines[counter] = next;
            counter++;
        }

        char[] comet = lines[0].toCharArray();
        char[] group = lines[1].toCharArray();

        int cometSum = 0;
        int groupSum = 0;

        for(int i = 0;i<6;i++){
            cometSum += (int)comet[i]-64;
            groupSum += (int)group[i]-64;
        }

        if((cometSum%47)==(groupSum%47)) System.out.println("GO");
        else System.out.println("STAY");

    }
}
