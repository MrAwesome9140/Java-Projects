import java.io.*;
import java.util.*;

public class cowland {

    static int N;
    static int Q;
    static Att[] atts;
    static HashMap<Integer, ArrayList<Att>> paths = new HashMap<>();
    static ArrayList<int[]> queries;
    static int[][] shortestPaths;
    static ArrayList<Integer> ans = new ArrayList<>();
    static int updated = 1;
    static int[][] pathUpdated;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("cowland.in")));
        BufferedWriter bw = new BufferedWriter(new FileWriter("cowland.out"));

        String[] tempse = br.readLine().split(" ");
        N = Integer.parseInt(tempse[0]);
        Q = Integer.parseInt(tempse[1]);
        atts = new Att[N+1];
        queries = new ArrayList<>();
        shortestPaths = new int[N+1][N+1];
        pathUpdated = new int[N+1][N+1];


        tempse = br.readLine().split(" ");
        for(int i = 0; i<N; i++) {
            atts[i+1] = new Att(i+1, Integer.parseInt(tempse[i]), null);
            paths.put(i+1, new ArrayList<>());
            shortestPaths[i+1][i+1] = Integer.parseInt(tempse[i]);
        }

        for(int i = 0; i<N-1; i++){
            tempse = br.readLine().split(" ");
            Att first = atts[Integer.parseInt(tempse[0])], second = atts[Integer.parseInt(tempse[1])];
            paths.get(first.key).add(second);
            paths.get(second.key).add(first);
        }

        for(int i = 0; i<Q; i++){
            tempse = br.readLine().split(" ");
            if(Integer.parseInt(tempse[0])==2) {
                int[] temp = new int[]{Integer.parseInt(tempse[1]), Integer.parseInt(tempse[2])};
                queries.add(temp);
                solve(temp);
            }
            else {
                atts[Integer.parseInt(tempse[1])].enjoy = Integer.parseInt(tempse[2]);
                shortestPaths[Integer.parseInt(tempse[1])][Integer.parseInt(tempse[1])] = Integer.parseInt(tempse[2]);
                updated++;
            }
        }

        ans.forEach(integer -> {
            try {
                bw.write(integer+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        bw.close();

    }

    static void solve(int[] sol){
        if(shortestPaths[sol[0]][sol[1]] == updated){
            ans.add(shortestPaths[sol[0]][sol[1]]);
            return;
        }
        bfs(atts[sol[0]], atts[sol[1]]);
        ans.add(shortestPaths[sol[0]][sol[1]]);
    }

    static void bfs(Att start, Att end){
        boolean[] searched = new boolean[N+1];
        Queue<Att> adjacent = new PriorityQueue();
        ArrayList<Att> temp = paths.get(start.key);
        temp.forEach(att -> {
            att.previous = start;
            adjacent.add(att);
        });
        searched[start.key] = true;
        Att current = adjacent.poll();
        while(!current.equals(end)){
            searched[current.key] = true;
            int total = shortestPaths[start.key][current.previous.key]^current.enjoy;
            shortestPaths[start.key][current.key] = total;
            pathUpdated[start.key][current.key] = updated;
            shortestPaths[current.key][start.key] = total;
            pathUpdated[start.key][current.key] = updated;
            Att finalCurrent = current;
            paths.get(current.key).forEach(att -> {
                if(!searched[att.key]) {
                    att.previous = finalCurrent;
                    adjacent.add(att);
                    searched[att.key] = true;
                }
            });
            current = adjacent.poll();
        }
        int tot = shortestPaths[start.key][current.previous.key]^current.enjoy;
        shortestPaths[start.key][current.key] = tot;
        shortestPaths[current.key][start.key] = tot;
    }

}

class Att implements Comparable<Att>{

    final int key;
    int enjoy;
    Att previous;

    public Att(int key, int enjoy, Att previous){
        this.key = key;
        this.enjoy = enjoy;
        this.previous = previous;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Att)) return false;
        Att att = (Att) o;
        return key == att.key &&
                enjoy == att.enjoy;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, enjoy, previous);
    }

    @Override
    public int compareTo(Att o) {
        return 0;
    }
}
