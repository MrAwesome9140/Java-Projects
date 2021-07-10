/*
ID: aaroh.sh
LANG: JAVA
TASK: combo
*/

import java.io.*;
import java.util.*;

public class combo {

    static List<String> usedNums = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("combo.in")));
        int N = Integer.parseInt(br.readLine());
        String[] combo1Temp = br.readLine().split(" ");
        String[] combo2Temp = br.readLine().split(" ");

        int[] combo1 = new int[combo1Temp.length];
        int[] combo2 = new int[combo2Temp.length];

        for(int i = 0; i<3; i++){
            combo1[i] = Integer.parseInt(combo1Temp[i]);
            combo2[i] = Integer.parseInt(combo2Temp[i]);
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("combo.out")));

        if(N>1) {
            numPossible(combo1, N);
            numPossible(combo2, N);

            bw.write(String.valueOf(usedNums.size()) + "\n");
        }
        else
            bw.write(String.valueOf(1) + "\n");
        bw.close();

    }

    public static void numPossible(int[] combo, int N){
        int firstMin = combo[0]-2;
        int firstMax = combo[0]+2;
        int secondMax = combo[1]+2;
        int secondMin = combo[1]-2;
        int thirdMin = combo[2]-2;
        int thirdMax = combo[2]+2;
        for(int i = firstMin; i<=firstMax; i++){
            for(int j = secondMin; j<=secondMax; j++){
                for(int k = thirdMin; k<=thirdMax; k++){
                    int firstTemp = i;
                    int secondTemp = j;
                    int thirdTemp = k;

                    if(firstTemp<=0)
                        firstTemp = N+firstTemp;
                    else if(firstTemp>N)
                        firstTemp-=N;

                    if(secondTemp<=0)
                        secondTemp = N+secondTemp;
                    else if(secondTemp>N)
                        secondTemp-=N;

                    if(thirdTemp<=0)
                        thirdTemp = N+thirdTemp;
                    else if(thirdTemp>N)
                        thirdTemp-=N;

                    String comb = String.valueOf(firstTemp)+" " +String.valueOf(secondTemp)+" "+String.valueOf(thirdTemp);
                    if(!usedNums.contains(comb)) {
                        usedNums.add(comb);
                    }
                }
            }
        }

    }

}
