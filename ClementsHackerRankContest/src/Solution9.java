import java.util.Arrays;
import java.util.Scanner;

public class Solution9 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] temp = sc.nextLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        long k = Long.parseLong(temp[1]);
        if(k == 0)
            System.out.println(0);
        else {
            String[] nums = sc.nextLine().split(" ");
            long[] vals = new long[n];
            for (int i = 0; i < n; i++) {
                vals[i] = Long.parseLong(nums[i]);
            }
            Arrays.sort(vals);
            long maxLen = 0;
            for (int i = 0; i < vals.length; i++) {
//                if(maxLen == vals.length)
//                    break;
//                long start = vals[i];
//                int cur = i + 1;
//                long tot = 1;
//                while (cur < vals.length && vals[cur] - start <= 5) {
//                    cur++;
//                    tot++;
//                }
                maxLen = Math.max(maxLen, binarySearch(vals, i, k));
            }
            System.out.println(maxLen);
        }

    }

    static long binarySearch(long[] vals, long num,long k){
        long l = num;
        long h = vals.length-1;
        long val = vals[(int)num];
        while(h!=l){
            long mid = (l+h+1)/2;
            long t = vals[(int) mid];
            if(t-val>k)
                h=mid-1;
            else
                l=mid;
        }
        return l-num+1;
    }

}
