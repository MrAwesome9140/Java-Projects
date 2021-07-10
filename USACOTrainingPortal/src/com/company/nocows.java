/*
ID: aaroh.sh
LANG: JAVA
TASK: nocows
*/

import java.io.*;
import java.util.*;

public class nocows {

    static int[][] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("nocows.in")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("nocows.out")));

        String[] temp = br.readLine().split("\\s++");

        int N = Integer.parseInt(temp[0]);
        int K = Integer.parseInt(temp[1]);

        trees = new int[N+1][K+1];

        for(int[] i: trees)
            Arrays.fill(i, -1);

        bw.write(String.valueOf(solve(N, K)));
        bw.newLine();
        bw.close();

    }



    static int solve(int N, int K){
        if(trees[N][K]!=-1)
            return trees[N][K];
        if(N<1 || K<1 || 2*K-1>N || N%2==0)
            return trees[N][K] = 0;
        if(N==1){
            if(K==1){
                return trees[N][K] = 1;
            }
            return trees[N][K] = 0;
        }
        trees[N][K] = 0;
        for(int i = 1; i<N-1; i+=2){
            int temp = N-i-1;
            for(int j = 0; j<K-1; j++){
                trees[N][K] += solve(i, j)*solve(temp, K-1);
                trees[N][K] += solve(i,K-1)*solve(temp, j);
            }
            trees[N][K] += solve(i, K-1)*solve(temp, K-1);
        }
        trees[N][K]%=9901;
        return trees[N][K];
    }

}
