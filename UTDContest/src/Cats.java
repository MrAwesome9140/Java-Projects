import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Cats {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int tests = Integer.parseInt(sc.nextLine());

        for(int i = 0; i<tests; i++){
            String[] temp = sc.nextLine().split(" ");
            int M = Integer.parseInt(temp[0]);
            int C = Integer.parseInt(temp[1]);
            int combos = (C*(C-1))/2;
            int[][] paths = new int[C][C];
            for(int j = 0; j<combos; j++){
                String[] te = sc.nextLine().split(" ");
                int cat1 = Integer.parseInt(te[0]);
                int cat2 = Integer.parseInt(te[1]);
                int d = Integer.parseInt(te[2]);
                paths[cat1][cat2] = d;
                paths[cat2][cat1] = d;
            }
            if(solve(0, 0, new boolean[C], M, C, 0, paths))
                System.out.print("yes");
            else
                System.out.print("no");
            if(i!=tests-1)
                System.out.println();
        }
    }

    static boolean solve(int current, int dist, boolean[] searched, int M, int C, int found, int[][] paths){
        searched[current] = true;
        int f = found+1;

        if(f==C && M-dist>=C)
            return true;
        if(M-dist<C)
            return false;

        int[] adj = paths[current];
        for(int i = 0; i<adj.length; i++){
            if(!searched[i]){
                if(solve(i, dist+adj[i], searched.clone(), M, C, f, paths))
                    return true;
            }
        }
        return false;
    }

    static boolean altSolve(int M, int C, int[][] paths){
        int[] c = new int[C];
        int[] e = new int[C];
        for(int i = 0; i<paths.length; i++){
            int[] adj = paths[i];
            int minDist = Integer.MAX_VALUE;
            int edge = 0;
            for(int j = 0; j<adj.length; j++){
                if(adj[j]<minDist){
                    minDist = adj[j];
                    edge = j;
                }
            }
            c[i] = minDist;
            e[i] = edge;
        }
        int[] minSpanTree = new int[C];
        Set<Integer> nums = new HashSet<>();
        for(int i = 0; i<C; i++)
            nums.add(i);
        while(!nums.isEmpty()){
            int minVert = 0;
            int minDist = Integer.MAX_VALUE;
            for(Integer i:nums){
                if(c[i]<minDist){
                    minDist = c[i];
                    minVert = i;
                }
            }
        }
        return true;
    }

}
