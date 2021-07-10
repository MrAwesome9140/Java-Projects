/*
ID: aaroh.sh
LANG: JAVA
TASK: pprime
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class pprime {

    static ArrayList<Integer> pprimes;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("pprime.in")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("pprime.out")));

        String[] strings = br.readLine().split(" ");

        int A = Integer.parseInt(strings[0]);
        int B = Integer.parseInt(strings[1]);

        pprimes = new ArrayList<>();

        String[] pals = new String[20];

        for(int i = 0; i<=9; i++){
            pals[i] = String.valueOf(i);
            pals[i+10] = String.valueOf(i*10+i);
        }

        pals[10] = "00";

        for(int i = 0; i<20; i++){
            solve(A,B,pals[i]);
        }

        Collections.sort(pprimes);

        for(int i:pprimes){
            bw.write(String.valueOf(i));
            bw.newLine();
        }

        bw.close();
    }

    static void solve(int A, int B, String solveIt){
        if(isPrime(Integer.parseInt(solveIt)) && A<=Integer.parseInt(solveIt) && B>=Integer.parseInt(solveIt)) pprimes.add(Integer.parseInt(solveIt));
        if(solveIt.length()+2>String.valueOf(B).length()) return;
        for(int i = 0; i<=9; i++) solve(A,B,i+solveIt+i);
    }

    static boolean isPrime(int i){
        if(i%2!=0){
            for(int k = 3; k<=(int)Math.sqrt((double) i); k+=2){
                if(i%k==0)
                    return false;
            }
            return true;
        }
        return false;
    }
}
