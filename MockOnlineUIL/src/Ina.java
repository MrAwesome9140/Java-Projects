import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Ina {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("ina.dat")));

        int T = Integer.parseInt(br.readLine());

        for(int u = 0; u<T; u++){
            String[] strings = br.readLine().split("\\s++");
            int N = Integer.parseInt(strings[0]);
            int S = Integer.parseInt(strings[1]);
            int L = Integer.parseInt(strings[2]);

            HashMap<Integer, ArrayList<Integer>> tree = new HashMap<>();
            for(int i = 0; i<N-1; i++){
                String[] temp = br.readLine().split("\\s++");
                int first = Integer.parseInt(temp[0]);
                int second = Integer.parseInt(temp[1]);
                if(tree.containsKey(first))
                    tree.get(first).add(second);
                else {
                    tree.put(first, new ArrayList<>());
                    tree.get(first).add(second);
                }

                if(tree.containsKey(second))
                    tree.get(second).add(first);
                else {
                    tree.put(second, new ArrayList<>());
                    tree.get(second).add(first);
                }
            }

            boolean[] tested = new boolean[N+1];
            tested[S] = true;
            int time = 0;
            while(!allTrue(tested)){
                ArrayList<Integer> remove = new ArrayList<>();
                for(int i:tree.keySet()){
                    if(tested[i]){
                        ArrayList<Integer> neighbors = tree.get(i);
                        int val = 0;
                        int maxSize = Integer.MIN_VALUE;
                        for(int k:neighbors){
                            if(tree.get(k).size()>maxSize && !tested[k]){
                                maxSize = tree.get(k).size();
                                val = k;
                            }
                        }
                        if(val>0)
                            remove.add(val);
                    }
                }
                time+=L;
                remove.forEach(s -> tested[s] = true);
            }

            System.out.println("Case #"+(u+1)+": "+time);

        }

    }

    static boolean allTrue(boolean[] tested){
        for(int i = 1; i<tested.length; i++){
            if(!tested[i])
                return false;
        }
        return true;
    }

}
