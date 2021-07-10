import java.io.*;

public class maxcross {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("maxcross.in")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("maxcross.out")));
        String[] initT = br.readLine().split(" ");
        int N = Integer.parseInt(initT[0]);
        int K = Integer.parseInt(initT[1]);
        int B = Integer.parseInt(initT[2]);

        int[] totBroken = new int[N+1];
        int[] broke = new int[N+1];
        for(int i = 0; i<B; i++){
            broke[Integer.parseInt(br.readLine())] = 1;
        }
        br.close();

        for(int i = 1; i<N+1; i++){
            totBroken[i] = totBroken[i-1]+broke[i];
        }

        int minNeeded = Integer.MAX_VALUE;
        for(int i = K; i<N+1; i++){
            int totBetween = totBroken[i]-totBroken[i-K];
            minNeeded = Math.min(minNeeded, totBetween);
        }

        bw.write(String.valueOf(minNeeded));
        bw.close();

    }

}
