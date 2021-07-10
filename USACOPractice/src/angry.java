import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class angry {

    static int n;
    static int k;
    static int[] bales;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("angry.in")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("angry.out")));
        String[] t = br.readLine().split(" ");

        n = Integer.parseInt(t[0]);
        k = Integer.parseInt(t[1]);
        bales = new int[n];

        for(int i = 0; i<n; i++){
            bales[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bales);

        int range = bales[bales.length-1]-bales[0];
        int posR = range/k;
        ArrayList<Integer> rangeR = new ArrayList<>();

        for(int i = 0; i<n; i++){
            int temp = bales[i];
            int cur = i+1;
            while(cur<bales.length && bales[cur]-posR<=temp)
                cur++;
            cur--;
            rangeR.add((int)Math.ceil((bales[cur]-temp)/2.0));
            i = cur;
        }

        ArrayList<Integer> rangeR2 = new ArrayList<>();

        for(int i = n-1; i>=0; i--){
            int temp = bales[i];
            int cur = i-1;
            while(cur>=0 && bales[cur]+posR>=temp)
                cur--;
            cur++;
            rangeR2.add((int)Math.ceil((temp-bales[cur])/2.0));
            i = cur;
        }

        Collections.sort(rangeR);
        Collections.sort(rangeR2);
        bw.write(String.valueOf(Math.min(rangeR.get(rangeR.size()-1), rangeR2.get(rangeR.size()-1))));
        bw.close();

    }

}
