/*
ID: aaroh.sh
LANG: JAVA
TASK: sprime
*/

import java.util.*;
import java.io.*;

public class sprime {

    static ArrayList<Integer> sprimes;
    static int[] singleDigPrimes = {2,3,5,7};

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new FileReader(new File("sprime.in")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("sprime.out")));

        sprimes = new ArrayList<>();

        int length = Integer.parseInt(br.readLine());

        for(int i = 0; i<singleDigPrimes.length; i++){
            solve(singleDigPrimes[i], length);
        }

        Collections.sort(sprimes);

        for(int i:sprimes){
            bw.write(String.valueOf(i));
            bw.newLine();
        }

        bw.close();

    }

    static void solve(int number, int length){
        if(!isPrime(number)) return;
        else if(String.valueOf(number).length()==length) sprimes.add(number);
        for(int i = 1; i<=9; i+=2){
            solve(Integer.parseInt(String.valueOf(number)+String.valueOf(i)), length);
        }
    }

    static boolean isPrime(int i){
        if(i!=2 && i%2==0) return false;
        for(int k = 3; k<=(int)Math.sqrt((double)i); k+=2) {
            if (i % k == 0)
                return false;
        }
        return true;
    }

}
