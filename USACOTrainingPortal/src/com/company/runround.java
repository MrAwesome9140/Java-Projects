/*
ID: aaroh.sh
LANG: JAVA
TASK: runround
*/

import java.io.*;

public class runround {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new FileReader(new File("runround.in")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("runround.out")));

        long M = Long.parseLong(br.readLine());

        long answer = Long.MIN_VALUE;

        while(answer==Long.MIN_VALUE){
            M++;
            if(!String.valueOf(M).contains("0") && isRunaround(M))
                answer = M;
        }
        bw.write(String.valueOf(answer));
        bw.newLine();
        bw.close();
    }

    static boolean isRunaround(long num){
        boolean[] used = new boolean[10];
        String useThis = String.valueOf(num);
        int startPos = 0;
        int curPos = 0;
        int digitsChecked = 1;
        int dig = 0;
        boolean stop = false;
        do{
            dig = Integer.parseInt(String.valueOf(useThis.charAt(curPos)));
            if(!used[dig]) {
                curPos = position(useThis, dig, curPos);
                digitsChecked++;
                used[dig] = true;
            }
            else{
                stop = true;
            }
        }while(!stop && startPos!=curPos);
        return !stop && --digitsChecked==useThis.length();
    }

    static int position(String useThis, int move, int current){
        while(move>0){
            if(current+1>=useThis.length()){
                current = 0;
            }
            else
                current++;
            move--;
        }
        return current;
    }

}
