import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class dancemooves {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] pos = new int[N+1];
        HashSet<Integer>[] reaches = new HashSet[N+1];
        for(int i = 1; i<pos.length; i++) {
            pos[i] = i;
            reaches[i] = new HashSet<>();
            reaches[i].add(i);
        }
        for(int i = 0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int[] swap = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            reaches[pos[swap[0]]].add(swap[1]);
            reaches[pos[swap[1]]].add(swap[0]);
            int temp = pos[swap[0]];
            pos[swap[0]] = pos[swap[1]];
            pos[swap[1]] = temp;
        }
        int[] ans = new int[N+1];
        boolean[] done = new boolean[N+1];
        for(int i = 1; i<=N; i++){
            int curEnds = i;
            if(pos[i]!=0){
                HashSet<Integer> tempReach = new HashSet<>(reaches[i]);
                List<Integer> s = new ArrayList<>();
                while (!done[curEnds]) {
                    done[curEnds] = true;
                    s.add(curEnds);
                    tempReach.addAll(reaches[curEnds]);
                    curEnds = pos[curEnds];
                    pos[s.get(s.size()-1)] = 0;
                }
                for (Integer p : s) {
                    ans[p] = tempReach.size();
                }

            }
        }
        StringBuilder out = new StringBuilder();
        for (int j = 1; j <= N; j++) {
            out.append(ans[j]).append('\n');
        }
        System.out.print(out);

    }

}


