package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class lifeguards {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("lifeguards.in")));
        int N = Integer.parseInt(br.readLine());
        int[][] times = new int[N][2];

        for(int i = 0; i<N; i++){
            String[] t = br.readLine().split(" ");
            times[i][0] = Integer.parseInt(t[0]);
            times[i][1] = Integer.parseInt(t[1]);
        }

        Arrays.sort(times, Comparator.comparingDouble(a -> a[0]));

        int greatest = 0;

        int index = 0;

        for(int i = 0; i<times.length; i++){
            int temp = i+1;
            int temp2 = i-1;
            int largest = 0;
            while(temp<times.length && times[temp][0]<times[i][1]){
                if(times[i][1]-times[temp][0]>greatest) {
                    largest = times[i][1] - times[temp][0];
                }
                temp++;
            }
            while(temp2>=0 && times[temp2][1]>times[i][0]){
                if(times[temp2][1]-times[i][0]+largest>greatest){
                    greatest = times[temp2][1]-times[i][0]+largest;
                    index = i;
                }
                temp2--;
            }
        }

        times[index] = new int[]{Integer.MIN_VALUE,Integer.MIN_VALUE};

        int totalTime = 0;

        for(int i = 0; i<times.length; i++){
            if(times[i][0]>=0 && times[i][1]>=0){
            }
        }
    }

}
