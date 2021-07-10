/*
ID: aaroh.sh
LANG: JAVA
TASK: milk2Personal
*/

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class milk2Personal {

    public static void main(String[] args) throws IOException {

        BufferedReader br  = new BufferedReader(new FileReader(new File("milk2.in")));
        int lines = Integer.parseInt(br.readLine());
        int[][] ranges = new int[lines][2];
        for(int i = 0; i<lines; i++){
            String[] j = br.readLine().split(" ");
            ranges[i][0] = Integer.parseInt(j[0]);
            ranges[i][1] = Integer.parseInt(j[1]);
        }
        br.close();

        Arrays.sort(ranges, Comparator.comparingInt(a -> a[0]));

        int maxTime = 0;
        int sepTime = 0;

        if(lines == 1){
            maxTime = ranges[0][1]-ranges[0][0];
        }
        else {
            for (int i = 0; i < ranges.length; i++) {
                int counter = i + 1;
                int contTime = 0;
                int otherTime = ranges[i][1]-ranges[i][0];
                while (counter < ranges.length && ranges[counter][0] <= ranges[counter - 1][1]) {
                    contTime += ranges[counter][0] - ranges[counter - 1][0];
                    counter++;
                }
                contTime += ranges[counter - 1][1] - ranges[counter - 1][0];

                if(i<ranges.length-1) {
                    int temp = ranges[i + 1][0] - ranges[i][1];
                    if (temp > 0) {
                        boolean valid = true;
                        for (int k = 0; k < ranges.length; k++) {
                            if (ranges[k][0] < ranges[i + 1][0] && ranges[k][1] > ranges[i][1])
                                valid = false;
                        }
                        if (valid && temp > sepTime)
                            sepTime = temp;
                    }
                }

                if(otherTime>contTime && otherTime>maxTime){
                    maxTime = otherTime;
                }
                else if (contTime > maxTime) {
                    maxTime = contTime;
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("milk2.out")));
        bw.write(String.valueOf(maxTime) + " " + String.valueOf(sepTime) + "\n");
        bw.close();

    }
}
