//© A+ Computer Science  -  www.apluscompsci.com
//Name - Aaroh Sharma
//Date - 10/17/2020
//Class - 7
//Lab  - Odds and Evens

import java.io.*;
import java.util.*;

public class OddRunner {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("oddevent.dat"));
        while(sc.hasNextLine()) {
            OddEvenSets oes = new OddEvenSets(sc.nextLine()); // Create OddEvenSets from next line
            System.out.println(oes); // Print out odd and even sets
        }
    }
}

class OddEvenSets {
    private Set<Integer> odds;
    private Set<Integer> evens;

    public OddEvenSets() {
        odds = new TreeSet<>(); // Instantiate odds set
        evens = new TreeSet<>(); // Instantiate evens set
    }

    public OddEvenSets(String line) {
        odds = new TreeSet<>(); // Instantiate odds set
        evens = new TreeSet<>(); // Instantiate evens set
        StringTokenizer st = new StringTokenizer(line); // Create StringTokenizer for line
        while(st.hasMoreTokens()) {
            int x = Integer.parseInt(st.nextToken()); // Parse next int
            if(x%2==1)
                odds.add(x); // If odd, add to odds set
            else
                evens.add(x); // If even, add to evens set
        }
    }

    public String toString() {
        return "ODDS : " + odds + "\nEVENS : " + evens + "\n\n";
    }
}