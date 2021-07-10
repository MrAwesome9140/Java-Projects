/*
ID: aaroh.sh
LANG: JAVA
TASK: barn1
*/

import java.io.*;
import java.util.*;

public class barn1 {

    static ArrayList<Integer> usedNums = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("barn1.in")));
        String[] tempLine = br.readLine().split(" ");
        int M = Integer.parseInt(tempLine[0]);
        int S = Integer.parseInt(tempLine[1]);
        int C = Integer.parseInt(tempLine[2]);

        boolean greater = false;

        if(M>C)
            greater = true;

        int[] stalls = new int[C];

        for(int i = 0; i<C; i++){
            stalls[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(stalls);

        br.close();

        int totalStalls = 0;
        TreeMap<Integer, Integer> vals = new TreeMap<>();
        for(int i = 0; i<stalls.length-1; i++){
            vals.put(i, stalls[i+1]-stalls[i]);
        }

        Object[] leastNums = vals.entrySet().toArray();

        Integer[] least = new Integer[leastNums.length];

        for(int i = 0; i<leastNums.length; i++){
            Map.Entry<Integer, Integer> temp = (Map.Entry<Integer, Integer>) leastNums[i];
            least[i] = Integer.parseInt(temp.getValue().toString());
        }

        Arrays.sort(least, Comparator.reverseOrder());

        ArrayList<Integer> value = new ArrayList<>();

        int index = 0;
        if(!greater) {
            while (value.size() < M - 1) {
                if (getIndex(vals, least[index], false) != getIndex(vals, least[index + 1], false) + 1) {
                    value.add(least[index]);
                }
                index++;
            }
        }
        ArrayList<Integer> indices = new ArrayList<>();

        for(int i:value){
            int key = getIndex(vals, i, true);
            indices.add(key);
        }

        Collections.sort(indices);

        for(int i = 0; i<indices.size(); i++){
            if(i == 0){
                totalStalls+=stalls[indices.get(i)]-stalls[0]+1;
            }
            else{
                totalStalls+=stalls[indices.get(i)]-stalls[indices.get(i-1)+1]+1;
            }
        }

        if(M!=1 && !(M>C) && indices.get(indices.size()-1)+1 < stalls.length)
            totalStalls+=stalls[stalls.length-1]-stalls[indices.get(indices.size()-1)+1]+1;
        else if(M==1)
            totalStalls = stalls[stalls.length-1]-stalls[0]+1;
        else if(M>C)
            totalStalls = C;

        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("barn1.out")));
        bw.write(String.valueOf(totalStalls) + "\n");
        bw.close();

    }

    public static int getIndex(TreeMap<Integer, Integer> temp, int entry, boolean used){
        ArrayList<Integer> usedNum = new ArrayList<>();
        temp.forEach((key, value) -> {
            if(value == entry)
                usedNum.add(key);
        });
        int index = 0;
        while(usedNums.contains(usedNum.get(index))){
            index++;
        }
        if(used)
            usedNums.add(usedNum.get(index));
        return usedNum.get(index);
    }

}
