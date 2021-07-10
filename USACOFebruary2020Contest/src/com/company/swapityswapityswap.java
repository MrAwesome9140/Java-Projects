import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class swapityswapityswap {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("swap.in")));
        String[] temp1 = br.readLine().split(" ");

        int N = Integer.parseInt(temp1[0]);
        int M = Integer.parseInt(temp1[1]);
        int K = Integer.parseInt(temp1[2]);

        int[][] switches = new int[M][2];

        for(int i = 0; i<M; i++){
            String[] temp = br.readLine().split(" ");
            switches[i][0] = Integer.parseInt(temp[0]);
            switches[i][1] = Integer.parseInt(temp[1]);
        }

        br.close();

        int[] nums = new int[N];
        int[] copy = new int[N];

        for(int i = 0; i<N; i++){
            nums[i] = i+1;
            copy[i] = i+1;
        }

        ArrayList<int[]> p = swapsTillSame(nums, copy, switches, K);
        int[] i = p.get(0);
        int leftover = i[1]%switches.length;
        if(i[0]==1) {
            K = K % (i[1] / switches.length);
            for (int j = 0; j < K; j++) {
                for (int num = 0; num < switches.length; num++) {
                    reverseOrder(nums, switches[num][0] - 1, switches[num][1] - 1);
                }
            }
        }
        else if(i[0]==0){
            nums = p.get(1);
            int left = switches.length-(i[1]%switches.length);

        }
        for(int num = 0; num<leftover; num++){
            reverseOrder(nums, switches[num][0]-1, switches[num][1]-1);
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("swap.out")));
        for(int k = 0; k<nums.length; k++){
            bw.write(String.valueOf(nums[k])+"\n");
        }
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

    public static ArrayList<int[]> swapsTillSame(int[] original, int[] temp, int[][] switches, int K){
        int i = 0;
        int[] k = new int[2];
        ArrayList<int[]> t = new ArrayList<>();
        for(int num = 0; num<switches.length; num++){
            reverseOrder(temp, switches[num][0]-1, switches[num][1]-1);
            i++;
        }
        while(!Arrays.equals(original, temp) && i<(K*switches.length)/2){
            for(int num = 0; num<switches.length; num++){
                reverseOrder(temp, switches[num][0]-1, switches[num][1]-1);
                if(Arrays.equals(original, temp)){
                    i++;
                    k[0] = 1;
                    k[1] = i;
                    t.add(k);
                    t.add(temp);
                    return t;
                }
                else{
                    i++;
                }
            }
        }
        t.add(new int[]{0,i});
        t.add(temp);
        return t;
    }

}
