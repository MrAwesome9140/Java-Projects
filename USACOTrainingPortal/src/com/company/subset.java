/*
ID: aaroh.sh
LANG: JAVA
TASK: subset
*/

import java.io.*;
import java.util.Arrays;

public class subset {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("subset.in")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("subset.out")));

        int N = Integer.parseInt(br.readLine());

        int target = (N*(N+1))/2;

        long[][] answers = new long[target][N+1];

        for(int i = 0; i<answers.length; i++){
            Arrays.fill(answers[i], -1);
        }

        if(target%2!=0) {
            bw.write("0");
            bw.newLine();
        }
        else{
            bw.write(String.valueOf(solve(answers,target/2,N)/2));
            bw.newLine();
        }
        bw.close();
    }

    static long solve(long[][] answers, int row, int col){
        if(row<0 || col<0)
            return 0;
        else if(answers[row][col]!=-1)
            return answers[row][col];
        else if(row == 0 && col == 0)
            return 1;
        return (answers[row][col] = solve(answers,row,col-1) + solve(answers,row-col,col-1));
    }

}
