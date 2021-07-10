/*
ID: aaroh.s1
TASK: gift1
LANG: JAVA
*/

package com.company;

import java.util.*;
import java.lang.*;
import java.io.*;

public class gift1 {

    public static void main(String[] args) throws IOException{
        ArrayList<Dictionary> test = new ArrayList<>();
        Map<String, Integer> people = new LinkedHashMap<>();
        BufferedReader bf = new BufferedReader(new FileReader("gift1.in"));
        String stuff = bf.readLine();
        int NP = Integer.parseInt(stuff);
        for(int i = 0; i<NP; i++){
            String temp = bf.readLine();
            people.put(temp, 0);
        }
        for (int i = 0; i<NP; i++){
            String giver = "";
            if((giver = bf.readLine()) != null) {
                String[] vals = bf.readLine().split(" ");
                int numMoney = Integer.parseInt(vals[0]);
                int numPeople = Integer.parseInt(vals[1]);
                if (numPeople != 0) {
                    int perPerson = numMoney / numPeople;
                    int leftOver = numMoney % numPeople;
                    people.put(giver, people.get(giver) - numMoney + leftOver);
                    for (int x = 0; x < numPeople; x++) {
                        String name = bf.readLine();
                        people.put(name, people.get(name) + perPerson);
                    }
                }
            }
        }
        bf.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter("gift1.out"));
        for(String s:people.keySet()){
            bw.write(s + " " + people.get(s) + "\n");
        }
        bw.close();
    }

}
