import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class water {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new File("water.dat"));
        int n = sc.nextInt();
        for(int i = 0; i<n; i++){
            int x=  sc.nextInt();
            int[][] pairs = new int[x][2];
            for(int j = 0; j<x; j++){
                int start = sc.nextInt(), end = sc.nextInt();
                pairs[j] = new int[]{start, end};
            }
            Arrays.sort(pairs, Comparator.comparingInt((a) -> a[0]));
            abandon(pairs);
        }
    }

    static void abandon(int[][] pairs){
        int totTime = 0;
        int i = 0;
        int curTime = 0;
        int numDrank = 0;
        while(i<pairs.length){
            numDrank++;
            int end = pairs[i][1], ind = i+1;
            while(ind < pairs.length && pairs[ind][1]<=end)
                ind++;
            totTime+=end-Math.max(curTime, pairs[i][0]);
            curTime = Math.max(end, ind<pairs.length?pairs[ind][0]:-1);
            i = ind;
        }
        System.out.println(numDrank+" "+(pairs.length-numDrank)+" "+totTime);
    }

}
