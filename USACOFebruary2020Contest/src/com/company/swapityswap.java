import java.io.*;
import java.util.*;

public class swapityswap {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("swap.in")));
        String[] temp1 = br.readLine().split(" ");

        int N = Integer.parseInt(temp1[0]);
        int K = Integer.parseInt(temp1[1]);

        String[] temp2 = br.readLine().split(" ");

        int A1 = Integer.parseInt(temp2[0]);
        int A2 = Integer.parseInt(temp2[1]);

        String[] temp3 = br.readLine().split(" ");

        int B1 = Integer.parseInt(temp3[0]);
        int B2 = Integer.parseInt(temp3[1]);

        br.close();

        int[] nums = new int[N];
        int[] copy = new int[N];

        for(int i = 0; i<N; i++){
            nums[i] = i+1;
            copy[i] = i+1;
        }

        if(K<100) {
            for (int i = 0; i < K; i++) {
                reverseOrder(nums, A1 - 1, A2 - 1);
                reverseOrder(nums, B1 - 1, B2 - 1);
            }
        }
        else{
            int i = swapsTillSame(nums, copy, A1, A2, B1, B2);
            K = K%i;
            for (int j = 0; j < K; j++) {
                reverseOrder(nums, A1 - 1, A2 - 1);
                reverseOrder(nums, B1 - 1, B2 - 1);
            }
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("swap.out")));
        for(int i = 0; i<nums.length-1; i++){
            bw.write(String.valueOf(nums[i])+"\n");
        }
        bw.write(String.valueOf(nums[nums.length-1]));
        bw.close();

    }

    public static void reverseOrder(int[] temp, int index1, int index2){
        int counter = 0;
        for(int i = index1; i<=index1+((index2-index1)/2); i++){
            int temper = temp[i];
            temp[i] = temp[index2-counter];
            temp[index2-counter] = temper;
            counter++;
        }
    }

    public static int swapsTillSame(int[] original, int[] temp, int A1, int A2, int B1, int B2){
        int i = 1;
        reverseOrder(temp, A1-1, A2-1);
        reverseOrder(temp, B1-1, B2-1);
        while(!Arrays.equals(original, temp)){
            reverseOrder(temp, A1-1, A2-1);
            reverseOrder(temp, B1-1, B2-1);
            i++;
        }
        return i;
    }

}
