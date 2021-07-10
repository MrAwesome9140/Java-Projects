import java.util.*;

public class MeetInModule {

    static int[][] paths;
    static int[] startLoc;
    static ArrayList<Integer> sols = new ArrayList<>();
    static int minWalk = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] temp = sc.nextLine().split(" ");
        int M = Integer.parseInt(temp[0]);
        int C = Integer.parseInt(temp[1]);
        int F = Integer.parseInt(temp[2]);
        paths = new int[M+1][M+1];
        startLoc = new int[F+1];
        for(int i = 0; i<C; i++){
            String[] te = sc.nextLine().split(" ");
            int first = Integer.parseInt(te[0]);
            int second = Integer.parseInt(te[1]);
            int dist = Integer.parseInt(te[2]);
            paths[first][second] = dist;
            paths[second][first] = dist;
        }
        for(int i = 1; i<=F; i++){
            startLoc[i] = Integer.parseInt(sc.nextLine());
        }

        solve(M, C, F);

        Collections.sort(sols);

        for(int i:sols){
            System.out.println(i);
        }

    }

    static void solve(int M, int C, int F){
        Queue<Integer> search = new PriorityQueue<>();
        for(int i = 1; i<=M; i++){
            boolean[] searched = new boolean[M+1];
            Arrays.fill(searched, false);
            int[] shortestDist = new int[M+1];
            search.add(i);
            while(!search.isEmpty()){
                int cur = search.poll();
                int[] adj = paths[cur];
                for(int k = 1; k<adj.length; k++){
                    if(adj[k] != 0 && !searched[k]){
                        search.add(k);
                        shortestDist[k] = shortestDist[cur]+adj[k];
                        searched[k] = true;
                    }
                }
            }
            int totDist = 0;
            for(int k = 1; k<startLoc.length; k++){
                totDist+=shortestDist[k];
            }
            if(totDist<minWalk){
                sols.clear();
                minWalk = totDist;
                sols.add(i);
            }
            else if(totDist==minWalk){
                sols.add(i);
            }
        }
    }

}
