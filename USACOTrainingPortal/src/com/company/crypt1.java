/*
ID: aaroh.sh
LANG: JAVA
TASK: crypt1
*/

import java.io.*;
import java.util.*;

public class crypt1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("crypt1.in")));
        int tempDigits = Integer.parseInt(br.readLine());

        String[] t = br.readLine().split(" ");

        br.close();

        Integer[] digits = new Integer[tempDigits];
        for(int i = 0; i<tempDigits; i++){
            digits[i] = Integer.parseInt(t[i]);
        }

        List<Integer> nums = Arrays.asList(digits);

        int[] digs3 = all3Digits(toPrimitve(digits));

        int[] digs2 = all2Digits(toPrimitve(digits));

        int possibles = 0;

        for(int i = 0; i<digs3.length; i++){
            for(int x = 0; x<digs2.length; x++){
                boolean gotem = true;
                int temp = digs2[x];
                while(temp>10){
                    int y = temp%10;
                    temp/=10;
                    int multiple = y*digs3[i];
                    if(multiple>=1000 || !allDigitsMembers(digits, multiple)){
                        gotem = false;
                    }
                }
                if(temp*digs3[i]>=1000 || !allDigitsMembers(digits, temp*digs3[i]))
                    gotem = false;

                if(gotem && allDigitsMembers(digits, digs2[x]*digs3[i])){
                    possibles++;
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("crypt1.out")));
        bw.write(String.valueOf(possibles)+"\n");
        bw.close();

    }

    public static boolean allDigitsMembers(Integer[] digits, int num){
        List<Integer> nums = Arrays.asList(digits);
        while(num>10){
            int temp = num%10;
            num/=10;
            if(!nums.contains(temp))
                return false;
        }
        if(nums.contains(num))
            return true;
        return false;
    }

    public static int[] all3Digits(int[] nums){
        ArrayList<Integer> temp = new ArrayList<>();
        for(int x = 0; x<nums.length; x++){
            for(int y = 0; y<nums.length; y++){
                for (int z = 0; z < nums.length; z++) {
                    String r = String.valueOf(nums[x]) + String.valueOf(nums[y]) + String.valueOf(nums[z]);
                    temp.add(Integer.parseInt(r));
                }
            }
        }
        int[] vals = new int[temp.size()];
        for(int i = 0; i<temp.size(); i++){
            vals[i] = temp.get(i);
        }
        return vals;
    }

    public static int[] all2Digits(int[] nums){
        ArrayList<Integer> temp = new ArrayList<>();
        for(int x = 0; x<nums.length; x++){
            for(int y = 0; y<nums.length; y++){
                String r = String.valueOf(nums[x]) + String.valueOf(nums[y]);
                temp.add(Integer.parseInt(r));
            }
        }
        int[] vals = new int[temp.size()];
        for(int i = 0; i<temp.size(); i++){
            vals[i] = temp.get(i);
        }
        return vals;
    }

    public static int[] toPrimitve(Integer[] temp){
        int[] news = new int[temp.length];
        for(int i = 0; i<temp.length; i++){
            news[i] = temp[i];
        }
        return news;
    }

}
