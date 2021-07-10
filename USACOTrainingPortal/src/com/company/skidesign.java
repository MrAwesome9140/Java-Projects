/*
ID: aaroh.sh
LANG: JAVA
TASK: skidesign
*/

import java.io.*;
import java.util.*;

public class skidesign {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new FileReader(new File("skidesign.in")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("skidesign.out")));

        int N = Integer.parseInt(br.readLine());
        int[] hills = new int[N];

        for(int i = 0; i<hills.length; i++){
            hills[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(hills);

        int minCost = Integer.MAX_VALUE;

        for(int i = 0; i<=100; i++){
            int cost = 0, x;
            for(int k = 0; k<N; k++){
                if(hills[k]<i)
                    x = i-hills[k];
                else if(hills[k]>i+17)
                    x = hills[k]-(i+17);
                else
                    x = 0;
                cost+=x*x;
            }
            minCost = Math.min(minCost,cost);
        }

        bw.write(String.valueOf(minCost)+"\n");
        bw.close();

    }

}
