import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class homework {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("homework.in")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("homework.out")));

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        String[] t = br.readLine().split(" ");
        for(int i = 0; i<N; i++)
            nums[i] = Integer.parseInt(t[i]);

        int[] minVal = new int[N];
        Arrays.fill(minVal, Integer.MAX_VALUE);
        minVal[N-1] = nums[N-1];
        int[] curSum = new int[N];
        curSum[N-1] = 0;
        int[] kAvg = new int[N];
        for(int j = N-2; j>=0; j--){
            int cur = nums[j];
            if(cur<minVal[j+1]){
                minVal[j] = cur;
                curSum[j] = curSum[j+1]+minVal[j+1];
                kAvg[j] = curSum[j]/(N-j-1);
            }
            else{
                minVal[j] = minVal[j+1];
                curSum[j] = curSum[j+1]+cur;
                kAvg[j] = curSum[j]/(N-j-1);
            }
        }

        ArrayList<Integer> answers = new ArrayList<>();
        int maxAvg = Integer.MIN_VALUE;
        for(int i = 0; i<kAvg.length; i++){
            if(kAvg[i]>maxAvg){
                maxAvg = kAvg[i];
                answers.clear();
                answers.add(i);
            }
            else if(kAvg[i]==maxAvg)
                answers.add(i);
        }

        for(int i = 0; i<answers.size()-1; i++){
            bw.write(String.valueOf(answers.get(i)+"\n"));
        }
        bw.write(String.valueOf(answers.get(answers.size()-1)));
        bw.close();

    }

}
