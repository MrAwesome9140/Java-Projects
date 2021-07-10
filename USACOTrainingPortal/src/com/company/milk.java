/*
ID: aaroh.sh
LANG: JAVA
TASK: milk
*/

import java.io.*;
import java.util.*;

public class milk {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("milk.in")));
        String[] strings = br.readLine().split(" ");
        int milkTarget = Integer.parseInt(strings[0]);

        int farmers = Integer.parseInt(strings[1]);


        //HashMap<Integer, Integer> milkVals = new HashMap<>();
        int[][] milkVals = new int[farmers][2];

        for(int i = 0;i<farmers; i++){
            String[] temp = br.readLine().split(" ");
            milkVals[i][0] = Integer.parseInt(temp[0]);
            milkVals[i][1] = Integer.parseInt(temp[1]);
        }

        br.close();

        Arrays.sort(milkVals, Comparator.comparingDouble(a -> a[0]));

        int totalCost = 0;
        int currentMilk = 0;
        int currentFarmer = 0;
        while(currentMilk<milkTarget){
            int tempMilk = currentMilk + milkVals[currentFarmer][1];
            if(tempMilk<milkTarget){
                totalCost+=milkVals[currentFarmer][0]*milkVals[currentFarmer][1];
                currentMilk+=milkVals[currentFarmer][1];
                currentFarmer++;
            }
            else{
                int milkTemp = milkTarget-currentMilk;
                totalCost+=milkTemp*milkVals[currentFarmer][0];
                currentMilk+=milkTemp;
            }
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("milk.out")));
        bw.write(String.valueOf(totalCost)+"\n");
        bw.close();

    }

}
