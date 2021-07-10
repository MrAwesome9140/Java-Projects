/*
ID: aaroh.sh
LANG: JAVA
TASK: transform
*/

import java.io.*;
import java.util.Arrays;

public class transform {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("transform.in")));
        int N = Integer.parseInt(br.readLine());
        String[][] original = new String[N][N];

        for(int i = 0; i<N; i++){
            char[] p = br.readLine().toCharArray();
            for(int k = 0; k<N; k++){
                original[i][k] = String.valueOf(p[k]);
            }
        }

        String[][] transformed = new String[N][N];

        for(int i = 0; i<N; i++){
            char[] p = br.readLine().toCharArray();
            for(int k = 0; k<N; k++){
                transformed[i][k] = String.valueOf(p[k]);
            }
        }

        int lowestType = 8;

        if(equal2dArrays(rotation90(original), transformed))
            lowestType = 1;
        else if(equal2dArrays(rotation90(rotation90(original)), transformed))
            lowestType = 2;
        else if(equal2dArrays(rotation90(rotation90(rotation90(original))), transformed))
            lowestType = 3;
        else if(equal2dArrays(reflection(original), transformed))
            lowestType = 4;
        else if(equal2dArrays(reflection(rotation90(rotation90(rotation90(original)))), transformed) || equal2dArrays(reflection(rotation90(rotation90(original))), transformed) || equal2dArrays(reflection(rotation90(original)), transformed))
            lowestType = 5;
        else if(noChange(original, transformed))
            lowestType = 6;
        else
            lowestType = 7;

        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("transform.out")));
        bw.write(String.valueOf(lowestType)+"\n");
        bw.close();

    }

    static String[][] rotation90(String[][] org){
        String[][] transformed = new String[org.length][org.length];
        for(int i = 0; i<org.length; i++){
            for(int k = 0; k<org.length; k++){
                transformed[i][k] = org[org.length-1-k][i];
            }
        }
        return transformed;
    }

    static String[][] reflection(String[][] org){
        String[][] transformed = new String[org.length][org.length];
        for(int i = 0; i<org.length; i++){
            for(int k = 0; k<org.length; k++){
                transformed[i][k] = org[i][org.length-1-k];
            }
        }
        return transformed;
    }

    static boolean noChange(String[][] org, String[][] copy){
        return equal2dArrays(org, copy);
    }

    static boolean equal2dArrays(String[][] arr1, String[][] arr2){
        for (int i = 0; i < arr1.length; i++) {
            if (!Arrays.equals(arr1[i], arr2[i])) {
                return false;
            }
        }
        return true;
    }

}
