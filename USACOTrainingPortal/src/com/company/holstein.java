/*
ID: aaroh.sh
LANG: JAVA
TASK: holstein
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class holstein {

    static int[] requires;
    static int[][] scoops;
    static int minScoops = Integer.MAX_VALUE;
    static ArrayList<Integer> feedTypes;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new FileReader(new File("holstein.in")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("holstein.out")));

        int V = Integer.parseInt(br.readLine());
        requires = new int[V];

        feedTypes = new ArrayList<>();

        String[] wows = br.readLine().split("\\s+");
        for(int i = 0; i<wows.length; i++){
            requires[i] = Integer.parseInt(wows[i]);
        }

        int G = Integer.parseInt(br.readLine());
        scoops = new int[G][V];

        HashMap<Integer, ArrayList<Integer>> uses = new HashMap<>();

        for(int i = 0; i<G; i++){
            uses.put(i, new ArrayList<>());
            String[] strings = br.readLine().split("\\s+");
            for(int k = 0; k<V; k++){
                scoops[i][k] = Integer.parseInt(strings[k]);
            }
        }

        ArrayList<Integer> dontUse = new ArrayList<>();

        for(int i = 0; i<scoops.length; i++){
            solve(requires.clone(), scoops, i, new ArrayList<>(), (ArrayList<Integer>) dontUse.clone());
            dontUse.add(i);
        }

        Collections.sort(feedTypes);

        bw.write(String.valueOf(minScoops)+" ");
        for (int i = 0; i<feedTypes.size()-1; i++) {
            bw.write(String.valueOf(feedTypes.get(i)+1)+" ");
        }
        bw.write(String.valueOf(feedTypes.get(feedTypes.size()-1)+1));
        bw.newLine();
        bw.close();

    }

    static void solve(int[] requires, int[][] scoops, int current, ArrayList<Integer> needed, ArrayList<Integer> dontUse){
        boolean complete = true;
        for(int i = 0; i<requires.length; i++){
            requires[i]-=scoops[current][i];
            if(requires[i]>0)
                complete = false;
        }
        needed.add(current);
        if(complete){
            if(needed.size()<minScoops || (needed.size()==minScoops && needed.get(0)<feedTypes.get(0))){
                minScoops = needed.size();
                feedTypes = (ArrayList<Integer>) needed.clone();
            }
        }
        else if(needed.size()>=minScoops){
            return;
        }
        else{
            for(int i = current+1; i<scoops.length; i++){
                if(!needed.contains(i) && !dontUse.contains(i)){
                    solve(requires.clone(), scoops, i, (ArrayList<Integer>) needed.clone(), dontUse);
                }
            }
        }
    }

}
