import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class berries {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("3.in")));
        String[] wow = br.readLine().split(" ");
        int N = Integer.parseInt(wow[0]);
        int K = Integer.parseInt(wow[1]);

        Integer[] trees = new Integer[N];
        int max = 0;
        String[] cars = br.readLine().split(" ");
        for(int i = 0; i<trees.length; i++) {
            int temp = Integer.parseInt(cars[i]);
            trees[i] = temp;
            max = Math.max(max, temp);
        }

        Arrays.sort(trees, Collections.reverseOrder());

        int greatest = 0;

//        for(int i = 1; i<=max; i++){
//            ArrayList<Integer> baskets = new ArrayList<>();
//            int curIndex = 0;
//            while(curIndex<trees.length && baskets.size()<K){
//                if(trees[curIndex]>=i){
//                    int temp = trees[curIndex];
//                    while(temp>=i && baskets.size()<K){
//                        baskets.add(i);
//                        temp-=i;
//                    }
//                }
//                else baskets.add(trees[curIndex]);
//                curIndex++;
//            }
//            int[] temp = new int[K];
//            for(int k = 0; k<baskets.size(); k++){
//                temp[k] = baskets.get(k);
//            }
//            Arrays.sort(temp);
//            int sum = 0;
//            for(int h = 0; h<temp.length/2; h++){
//                sum+=temp[h];
//            }
//            greatest = Math.max(greatest, sum);
//
//        }

        int ans = 0;
        for (int i = 1; i <= max; i++) {
            //Each of elsie's baskets have at least i berries.

            int fill = 0; //number of baskets that can be filled with i berries
            for (int j = 0; j < K; j++) {
                fill += (trees[j]/i);
            }
            if (fill >= K) {
                ans = i*(K/2); //Both Elsie and Bessie get the same number of berries
            } else {
                //Elsie gets more berries than Bessie.
                int[] temp = new int[K];
                for (int j = 0; j < K; j++) {
                    temp[j] = (trees[j]%i);
                }
                Arrays.sort(temp);
                int cnt = i*(fill-(K/2));
                for (int j = K-1; j >= fill; j--) {
                    cnt += temp[j];
                }
                ans = Math.max(ans,cnt);
            }
        }


        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("berries.out")));
        bw.write(String.valueOf(ans)+"\n");
        bw.close();

    }

}
