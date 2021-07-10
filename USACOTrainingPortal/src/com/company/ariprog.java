/*
ID: aaroh.sh
LANG: JAVA
TASK: ariprog
*/

import java.util.*;
import java.io.*;

public class ariprog {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new FileReader(new File("ariprog.in")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("ariprog.out")));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int max = 2*M*M;

        boolean[] bisquares = new boolean[max+1];

        for(int i = 0; i<=M; i++){
            for(int k = 0; k<=M; k++){
                bisquares[k*k+i*i] = true;
            }
        }

        ArrayList<ArrayList<Integer>> answers = new ArrayList<>();

        for(int i = 0; i<max; i++){
            if(!bisquares[i])
                continue;
            diffSum: for(int j = 1; j<=(max-i)/(N-1); j++){
                for(int k = 1; k<=N-1;k++){
                    if(!bisquares[i+k*j])
                        continue diffSum;
                }
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(j);
                answers.add(temp);
            }
        }

        Collections.sort(answers, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(1)-o2.get(1)==0?o1.get(0)-o2.get(0):o1.get(1)-o2.get(1);
            }
        });

        if(answers.size()==0)
            bw.write("NONE\n");
        else{
            for(int i = 0; i<answers.size(); i++){
                bw.write(String.valueOf(answers.get(i).get(0))+" "+String.valueOf(answers.get(i).get(1))+"\n");
            }
        }

        bw.close();
    }

}




