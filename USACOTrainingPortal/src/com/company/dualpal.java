/*
ID: aaroh.sh
LANG: JAVA
TASK: dualpal
*/

import java.io.*;
import java.util.ArrayList;

public class dualpal {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("dualpal.in")));
        String[] strings = br.readLine().split(" ");
        br.close();

        int N = Integer.parseInt(strings[0]);
        int S = Integer.parseInt(strings[1]);

        ArrayList<Integer> nums = new ArrayList<>();

        int temp = S+1;
        while(nums.size()<N){
            boolean has2 = false;
            int pals = 0;
            for(int i = 2; i<=10 && !has2; i++){
                if(isPalindrome(convertToBase(temp, i))){
                    pals++;
                }
                if(pals==2){
                    has2 = true;
                }
            }
            if(has2){
                nums.add(temp);
            }
            temp++;
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("dualpal.out")));
        for(int i:nums){
            bw.write(String.valueOf(i)+"\n");
        }
        bw.flush();
        bw.close();

    }

    public static String convertToBase(int num, int base){
        int maxDig = 1;
        int temp = base;
        while(temp<num){
            temp*=base;
            maxDig++;
        }
        String s = "";
        for(int i = maxDig-1; i>0; i--){
            double t = Math.pow(base,i);
            long y = num/(int)t;
            if(y<10&&y!=0) {
                s += String.valueOf(y);
            }
            else if(y>=10&&y!=0){
                s += (char)(55+y);
            }
            else{
                s += String.valueOf(0);
            }
            num%=(int)t;
        }
        if(num<10) {
            s += String.valueOf(num);
        }
        else{
            s += (char)(55+num);
        }
        return s;
    }

    public static boolean isPalindrome(String s){
        char[] c = s.toCharArray();
        for(int x = 0; x<c.length/2; x++){
            if(c[c.length-1-x]!=c[x])
                return false;
        }
        return true;
    }

}
