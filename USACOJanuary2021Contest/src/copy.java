import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class copy {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] te = br.readLine().split(" ");
        int N = Integer.parseInt(te[0]);
        int Q = Integer.parseInt(te[1]);
        HashMap<Character, Integer> lastIntst = new HashMap<>();
        int[][] cands = new int[Q][Q];
        String fence = br.readLine();
        for(int i = 0; i<fence.length(); i++){
            lastIntst.put(fence.charAt(i), i);
        }
        for(int i = 0; i<Q; i++){
            StringTokenizer temp = new StringTokenizer(br.readLine());
            cands[i] = new int[]{Integer.parseInt(temp.nextToken()), Integer.parseInt(temp.nextToken())};
        }

        for(int[] i:cands){
            int ans = 0;
            int start = i[0]-1;
            int end = i[1]-1;
            String pre = fence.substring(0, start);
            String post = fence.substring(end+1, N);
            HashMap<Character, ArrayList<Integer>> vals = new HashMap<>();
            for(int k = 0; k<pre.length(); k++){
                char test = pre.charAt(k);
                int temp = k+1;
                char cur;
                int tempAns = 0;
                while(temp<pre.length() && (cur=pre.charAt(temp))!=test){
                    if(cur<test) {
                        tempAns++;
                        break;
                    }
                    temp++;
                }
                ans+=tempAns;
                if(vals.containsKey(test)) {
                    vals.get(test).add(tempAns);
                }
                else {
                    ArrayList<Integer> tell = new ArrayList<>();
                    tell.add(tempAns);
                    vals.put(test, tell);
                }
            }
            for(Character c:vals.keySet()){
               ArrayList<Integer> nums = vals.get(c);
               ans+=1-nums.get(nums.size()-1);
            }
            vals.clear();
            for(int k = 0; k<post.length(); k++){
                char test = post.charAt(k);
                int temp = k+1;
                char cur;
                int tempAns = 0;
                while(temp<post.length() && (cur=post.charAt(temp))!=test){
                    if(cur<test) {
                        tempAns++;
                        break;
                    }
                    temp++;
                }
                ans+=tempAns;
                if(vals.containsKey(test))
                    vals.get(test).add(tempAns);
                else {
                    ArrayList<Integer> tell = new ArrayList<>();
                    tell.add(tempAns);
                    vals.put(test, tell);
                }
            }
            for(Character c:vals.keySet()){
                ArrayList<Integer> nums = vals.get(c);
                ans+=1-nums.get(nums.size()-1);
            }
            System.out.println(ans);

        }


    }

}
