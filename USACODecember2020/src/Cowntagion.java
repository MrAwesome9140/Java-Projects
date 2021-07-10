import java.util.*;

public class Cowntagion {

    static int[] numCows;
    static HashMap<Integer, ArrayList<Integer>> paths;
    static int n;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = Integer.parseInt(sc.nextLine());
        numCows = new int[n+1];
        paths = new HashMap<>();
        for(int i = 1; i<n+1; i++){
            numCows[i] = 1;
            paths.put(i, new ArrayList<>());
        }

        for(int i = 0; i<n-1; i++){
            String[] temp = sc.nextLine().split(" ");
            int loc1 = Integer.parseInt(temp[0]);
            int loc2 = Integer.parseInt(temp[1]);
            paths.get(loc1).add(loc2);
            paths.get(loc2).add(loc1);
        }

        if(n==1)
            System.out.print(1);
        else
            System.out.print(solve());

    }

    static int solve(){
        int ans = 0;
        boolean[] infect = new boolean[n+1];
        Queue<Integer> locs = new LinkedList<>();
        locs.add(1);
        infect[1] = true;
        while(!locs.isEmpty()){
            int cur = locs.poll();
            ArrayList<Integer> adjs = paths.get(cur);
            int numAdj = 0;
            boolean end = true;
            for(Integer i:adjs){
                if(!infect[i]) {
                    end = false;
                    infect[i] = true;
                    locs.add(i);
                    numAdj++;
                }
            }
            if(end)
                continue;
            int daysToFull = (int)Math.ceil(Math.log(numAdj)/Math.log(2));
            if(Math.pow(2, daysToFull) == numAdj){
                daysToFull++;
            }
            ans+=daysToFull;
            ans+=numAdj;
        }
        return ans;
    }

}
