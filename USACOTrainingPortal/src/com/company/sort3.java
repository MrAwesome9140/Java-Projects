/*
ID: aaroh.sh
LANG: JAVA
TASK: sort3
*/

import java.io.*;

public class sort3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("sort3.in")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("sort3.out")));

        int num = Integer.parseInt(br.readLine());

        int[] nums = new int[num];

        for(int i = 0; i<num; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }

        bw.write(String.valueOf(sort(nums)));
        bw.newLine();
        bw.close();

    }

    static int sort(int[] nums){
        int[] temp = new int[nums.length];
        int ones = 0;
        int twos = 0;
        for(int i = 0; i<temp.length; i++){
            if(nums[i]==1) ones++;
            else if(nums[i]==2) twos++;
        }

        for(int i = 0; i<temp.length; i++){
            if(i<ones) temp[i] = 1;
            else if(i<(ones+twos)) temp[i] = 2;
            else temp[i] = 3;
        }

        int i12 = 0;
        int i21 = 0;
        int i23 = 0;
        int i32 = 0;
        int i31 = 0;
        int i13 = 0;
        for(int i = 0; i<temp.length; i++){
            if(nums[i]==1 && temp[i]==2) i12++;
            else if(nums[i]==2 && temp[i]==1) i21++;
            else if(nums[i]==2 && temp[i]==3) i23++;
            else if(nums[i]==3 && temp[i]==2) i32++;
            else if(nums[i]==1 && temp[i]==3) i13++;
            else if(nums[i]==3 && temp[i]==1) i31++;
        }
        return Math.min(i12, i21)+Math.min(i23, i32)+Math.min(i13, i31)+2*(Math.max(i12,i21)-Math.min(i12, i21));
    }
}
