import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class convention {

    static int N;
    static int M;
    static int C;
    static int[] arrTimes;
    static ArrayList<Integer> waitTimes = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("convention.in")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("convention.out")));
        String[] init = br.readLine().split(" ");

        N = Integer.parseInt(init[0]);
        M = Integer.parseInt(init[1]);
        C = Integer.parseInt(init[2]);
        arrTimes = new int[N];
        int optimalAmount = N/M;
        int leftOver = N%M;
        int findMin = optimalAmount+leftOver;

        String[] second = br.readLine().split(" ");
        for(int i = 0; i<N; i++){
            arrTimes[i] = Integer.parseInt(second[i]);
        }

        Arrays.sort(arrTimes);
        int[] sums = new int[N];
        for(int i = 0; i<arrTimes.length-findMin; i++){
            int cur = arrTimes[i];
            //int
        }

        int curBus = 0;
        int curStartTime = 0;
        for(int i = 0; i<arrTimes.length; i++){
            curBus++;
            if(curBus == 1)
                curStartTime = arrTimes[i];
            else if(curBus == optimalAmount){
                waitTimes.add(arrTimes[i]-curStartTime);
                curBus = 0;
            }
        }

    }

}
