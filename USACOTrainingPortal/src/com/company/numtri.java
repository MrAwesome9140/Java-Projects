/*
ID: aaroh.sh
LANG: JAVA
TASK: numtri
*/

import java.util.*;
import java.io.*;

public class numtri {

    static int[][] results;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new FileReader(new File("numtri.in")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("numtri.out")));

        int rows = Integer.parseInt(br.readLine());

        results = new int[rows][rows];

        int[][] tempsi = new int[rows][rows];
        int currentIndex = 0;
        for(int i = 0; i<rows; i++){
            String[] temp = br.readLine().split(" ");
            for(int k = 0; k<temp.length; k++){
                results[i][k] = -1;
                tempsi[i][k] = Integer.parseInt(temp[k]);
            }
        }
        bw.write(String.valueOf(DFS(tempsi, 0,0)));
        bw.newLine();
        bw.close();

    }

    static int DFS(int[][] tree, int k, int j){
        if(k+1>=tree.length){
            return tree[k][j];
        }
        else if(results[k][j]!=-1){
            return results[k][j];
        }
        else{
            results[k][j] = tree[k][j]+Math.max(DFS(tree, k+1,j), DFS(tree, k+1,j+1));
            return results[k][j];
        }
    }

}