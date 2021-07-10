/*
ID: aaroh.sh
LANG: JAVA
TASK: hamming
*/

import java.io.*;
import java.util.ArrayList;

public class hamming {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("hamming.in")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("hamming.out")));

        String[] strings = br.readLine().split("\\s+");

        int N = Integer.parseInt(strings[0]);
        int B = Integer.parseInt(strings[1]);
        int D = Integer.parseInt(strings[2]);

        int max = (int) Math.pow(2,B+1);

        ArrayList<Integer> answers = new ArrayList<>();

        for(int i = 0; i<max && answers.size()<N; i++){
            if(i==0)
                answers.add(i);
            else{
                if(satisfy(answers, i, D))
                    answers.add(i);
            }
        }

        for(int i = 0; i<answers.size()-1; i++){
            if(i!=0 && i%10==0) {
                bw.newLine();
                bw.write(answers.get(i)+" ");
            }
            else if((i+1)%10==0)
                bw.write(String.valueOf(answers.get(i)));
            else
                bw.write(answers.get(i)+" ");
        }
        bw.write(answers.get(answers.size()-1)+"\n");
        bw.close();
    }

    static boolean satisfy(ArrayList<Integer> answers, int current, int D){
        for(Integer i:answers){
            String temp = Integer.toBinaryString((i^current));
            if(!hamSandwich(temp, D)){
                return false;
            }
        }
        return true;
    }

    static boolean hamSandwich(String binary, int D){
        int current1s = 0;
        for(int i = 0; i<binary.length(); i++){
            if(binary.charAt(i)=='1')
                current1s++;
            if(current1s>=D)
                return true;
        }
        return false;
    }

}
