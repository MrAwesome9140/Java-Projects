import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class notimetopaint {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        String fence = br.readLine();
        int[] indices = new int[26];
        for(int i = 0; i<26; i++){
            indices[i] = -1;
        }
        int[] preSums = new int[N];
        preSums[0] = 1;
        indices[fence.charAt(0)-'A']=0;
        for(int i = 1; i<fence.length(); i++){
            char cur = fence.charAt(i);
            int temp = indices[cur-'A'];
            if(temp==-1) {
                preSums[i] = preSums[i - 1] + 1;
            }
            else{
                boolean done = false;
                for(int k = 65; k<cur; k++){
                    if(indices[k-'A']>temp) {
                        done = true;
                        preSums[i] = preSums[i - 1] + 1;
                        break;
                    }
                }
                if(!done)
                    preSums[i] = preSums[i-1];
            }
            indices[cur-'A'] = i;
        }
        indices = new int[26];
        for(int i = 0; i<26; i++){
            indices[i] = Integer.MAX_VALUE;
        }
        int[] postSums = new int[N];
        postSums[N-1] = 1;
        indices[fence.charAt(N-1)-'A'] = N-1;
        for(int i = N-2; i>=1; i--){
            char cur = fence.charAt(i);
            int temp = indices[cur-'A'];
            if(temp==Integer.MAX_VALUE) {
                postSums[i] = postSums[i + 1] + 1;
            }
            else{
                boolean done = false;
                for(int k = 65; k<cur; k++){
                    if(indices[k-'A']<temp) {
                        done = true;
                        postSums[i] = postSums[i + 1] + 1;
                        break;
                    }
                }
                if(!done)
                    postSums[i] = postSums[i+1];
            }
            indices[cur-'A'] = i;
        }

        StringBuilder s = new StringBuilder();
        for(int i = 0; i<Q; i++){
            st = new StringTokenizer(br.readLine());
            int[] cand = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            int ans = 0;
            int start = cand[0]-1;
            int end = cand[1]-1;
            if(start>0)
                ans+=preSums[start-1];
            if(end<N-1)
                ans+=postSums[end+1];
            s.append(ans).append("\n");
        }
        System.out.print(s);
    }

}
