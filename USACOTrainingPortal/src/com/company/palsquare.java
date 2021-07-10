/*
ID: aaroh.sh
LANG: JAVA
TASK: palsquare
*/

import java.io.*;
import java.util.ArrayList;

public class palsquare {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("palsquare.in")));
        int base = Integer.parseInt(br.readLine());

        ArrayList<String> pairs = new ArrayList<>();

        for(int i = 1; i<=300; i++){
            if(isPalindrome(convertToBase((int)Math.pow(i,2),base))){
                pairs.add(convertToBase(i,base) + " " + convertToBase((int)Math.pow(i,2),base));
            }
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("palsquare.out")));
        for(String s:pairs){
            bw.write(s+"\n");
        }
        bw.flush();
        bw.close();
    }

    public static String convertToBase(long num, int base){
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
        else if(num>=10){
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
