import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] wow = br.readLine().split(" ");
        int N = Integer.parseInt(wow[0]);
        int K = Integer.parseInt(wow[1]);

        int[] years = new int[N];
        for(int i = 0; i<N; i++){
            years[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(years);
        PriorityQueue<Point> difs = new PriorityQueue<Point>(Comparator.comparingInt(p -> -p.x));
        for(int i = 1; i<years.length; i++){
            int val;
            int dif = years[i] - years[i - 1];
            if(years[i]%12!=0 || years[i-1]%12!=0) {
                val = (int) Math.ceil((dif / 12.0) + 1) * 12;
            }
            else{
                val = (dif)*12;
            }
            difs.add(new Point(val, i));
        }

        int[] splits = new int[K-2];
        for(int i = 0; i<K-2; i++){
            Point temp = difs.poll();
            splits[i] = temp.y;
        }

        Arrays.sort(splits);

        int last = 0;
        int sol = 0;
        for(int i = 0; i<splits.length; i++){
            int prevYear = years[last];
            int temp = years[splits[i]-1];
            while(temp%12!=0)
                temp++;
            int temp2 = prevYear;
            while(temp2%12!=0)
                temp2--;
            sol+=temp-temp2;
            last = splits[i];
        }
        int prevYear = years[splits[splits.length-1]];
        int temp = years[years.length-1];
        while(temp%12!=0)
            temp++;
        int temp2 = prevYear;
        while(temp2%12!=0)
            temp2--;
        sol+=temp-temp2;
        System.out.print(sol);

    }

}
