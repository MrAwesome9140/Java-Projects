import java.io.*;
import java.util.*;
import java.lang.*;

public class leftout {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new FileReader(new File("leftout.in")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("leftout.out")));

        int N = Integer.parseInt(br.readLine());

        boolean[][] square = new boolean[N][N];

        for(int i = 0; i<N; i++){
            String t = br.readLine();
            for(int j = 0; j<N; j++){
                if(t.charAt(j)=='L')
                    square[i][j] = true;
            }
        }

        boolean wow = false;

        for(int i = 0; i<N-1 && !wow; i++){
            for(int j = 0; j<N-1 && !wow; j++){
                int numTrue = 0;
                int numFalse = 0;
                for(int k = i; k<i+2; k++){
                    for(int y = j; y<j+2; y++){
                        if(square[k][y])
                            numTrue++;
                        else
                            numFalse++;
                    }
                }
                if((numTrue == 3 && numFalse == 1) || (numFalse == 3 && numTrue == 1)){
                    bw.write((i+1) + " " + (j+1));
                    wow = true;
                }
            }
        }

        if(!wow)
            bw.write("-1");

        bw.close();

    }

}
