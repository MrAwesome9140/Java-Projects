import java.io.*;
import java.util.ArrayList;

public class zerosum {

    static ArrayList<int[]> sols = new ArrayList<>();

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new FileReader(new File("zerosum.in")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("zerosum.out")));

        int n = Integer.parseInt(br.readLine());
        int total = n*(n+1)/4;
        int goal = total-1;
        for(int i = 2; i<=n; i++){
            

        }

    }

    static void solve(int n, int total, int curTotal, int[] positives){
        int goal = total-1;
        if(curTotal==goal)
            return;

    }

}
