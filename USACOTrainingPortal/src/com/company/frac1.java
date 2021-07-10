/*
ID: aaroh.sh
LANG: JAVA
TASK: frac1
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class frac1 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new FileReader(new File("frac1.in")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("frac1.out")));

        int N = Integer.parseInt(br.readLine());

        ArrayList<String> answers = new ArrayList<>();
        answers.add("0/1");

        for(int i = 1; i<=N; i++){
            for(int k = 1; k<=i; k++){
                String temp = simplifiedFraction(k,i);
                if(!answers.contains(temp))
                    answers.add(temp);
            }
        }

        Collections.sort(answers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] first = o1.split("/");
                String[] second = o2.split("/");
                double firstNum = (double) Integer.parseInt(first[0])/(double) Integer.parseInt(first[1]);
                double secondNum = (double) Integer.parseInt(second[0])/(double) Integer.parseInt(second[1]);
                return (int)(firstNum*10000000)-(int)(secondNum*10000000);
            }
        });

        for(String s:answers)
            bw.write(s+"\n");
        bw.close();

    }

    static int GCD(int a, int b){
        return b == 0?a:GCD(b, a%b);
    }

    static String simplifiedFraction(int a, int b){
        long gcd = GCD(a,b);
        return (a/gcd)+"/"+(b/gcd);
    }

}
