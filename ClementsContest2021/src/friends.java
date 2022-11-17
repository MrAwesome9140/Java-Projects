import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class friends {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new File("friends.dat"));
        int cnt = sc.nextInt();
        for(int i = 0; i<cnt; i++){
            int n = sc.nextInt(); int lines = sc.nextInt();l = 0; big = 0;
            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
            for(int k = 0; k < n; k++){
                arr.add(k, new ArrayList<>());
            }
            for(int k = 0; k<lines; k++){
                int a = sc.nextInt()-1;
                int b = sc.nextInt() - 1;
                arr.get(a).add(b);
                arr.get(b).add(a);
            }
            boolean visited[] = new boolean[n];
            for(int j = 0; j < n; j++){
                if(!visited[j])
                    dfs(j,visited,arr);
                big = Math.max(big, temp);
                temp = 0;
            }
            System.out.println("largest group: " + big);
            System.out.println("loners: " + l);
            if(i != cnt-1)System.out.println();
        }

    }
    static int big = 1;
    static int l = 0;
    static int temp = 0;
    public static void dfs(int i, boolean[] vis, ArrayList<ArrayList<Integer>> arr){
        vis[i] = true;temp++;
        if(arr.get(i).size() == 0){
            l++;
        }
        big = Math.max(big, temp);
        for(int j : arr.get(i)){
            if(!vis[j]){
                dfs(j, vis, arr);
            }
        }
    }

}
