import java.io.*;
import java.util.*;

public class Arach {

    static int n;
    static int m;
    static int t;
    static int[][] paths;
    static int start;
    static int end;
    static ArrayList<Integer> araLocs = new ArrayList<>();
    static int maxValueD = -1;
    static int[] closestSpi;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        //BufferedReader br = new BufferedReader(new FileReader("arach.in"));
        String[] temp = sc.nextLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        t = Integer.parseInt(temp[2]);
        paths = new int[n][n];
        for(int i = 0; i<n; i++)
            Arrays.fill(paths[i], -1);
        closestSpi = new int[n];
        Arrays.fill(closestSpi, Integer.MAX_VALUE);

        for(int i = 0; i<m; i++){
            String[] te = sc.nextLine().split(" ");
            int vert1 = Integer.parseInt(te[0]);
            int vert2 = Integer.parseInt(te[1]);
            int d = Integer.parseInt(te[2]);
            paths[vert1][vert2] = d;
            paths[vert2][vert1] = d;
        }

        String[] te = sc.nextLine().split(" ");
        start = Integer.parseInt(te[0]);
        end = Integer.parseInt(te[1]);

        String[] t = sc.nextLine().split(" ");
        for(int i = 1; i<t.length; i++){
            araLocs.add(Integer.parseInt(t[i]));
        }

        Collections.sort(araLocs);

        for(Integer i: araLocs){
            closestSpi[i] = 0;
            closestSpider(i);
        }

        solve(start, 0, closestSpi[start], new boolean[n]);

        System.out.print(maxValueD);

    }

    static void solve(int current, int tempT, int tempMinD, boolean[] searched){
        searched[current] = true;
        int tempTotD = Math.min(tempMinD, closestSpi[current]);
        if(current==end && tempT<=t) {
            maxValueD = Math.max(maxValueD, tempTotD);
            return;
        }
        if(tempT==t)
            return;

        int[] adj = paths[current];
        for(int i = 0; i<adj.length; i++){
            if(!searched[i] && adj[i]!=-1){
                solve(i, tempT+adj[i], tempTotD, searched.clone());
            }
        }
    }

    static void closestSpider(int vert){
        boolean[] searched = new boolean[n];
        int[] dist = new int[n];
        Queue<Integer> q = new PriorityQueue<>();
        q.add(vert);
        dist[vert] = 0;
        searched[vert] = true;
        while(!q.isEmpty()){
            int temp = q.poll();
            int[] adj = paths[temp];
            for(int i = 0;i<adj.length; i++){
                if(adj[i]!=0 && !searched[i] && adj[i]!=-1){
                    searched[i] = true;
                    dist[i] = dist[temp]+adj[i];
                    closestSpi[i] = Math.min(closestSpi[i], dist[i]);
                    q.add(i);
                }
            }
        }
    }

}
