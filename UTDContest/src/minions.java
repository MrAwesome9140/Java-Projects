import java.lang.reflect.Array;
import java.util.*;

public class minions {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        ArrayList<Prefs> prefs = new ArrayList<>();
        for(int i = 0; i<N; i++){
            String[] temp = sc.nextLine().split(" ");
            prefs.add(new Prefs(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
        }
        ArrayList<int[]> posMins = new ArrayList<>();

        Collections.sort(prefs, new Comparator<Prefs>() {
            @Override
            public int compare(Prefs o1, Prefs o2) {
                return o1.min-o2.min;
            }
        });

        int ans1 = 0;

        for(int i = 0; i<prefs.size(); i++){
            Prefs cur = prefs.get(i);
            int curMax = cur.max;
            int j = i+1;
            int same = 1;
            while(j<prefs.size() && prefs.get(j).min<=curMax) {
                j++;
                same++;
            }
            posMins.add(new int[]{i, same});
        }

        Collections.sort(posMins, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        HashSet<Integer> nums = new HashSet<>();
        for(int i = 0; i<N; i++)
            nums.add(i);

        int cur = 0;
        while(!nums.isEmpty()){
            int[] temp = posMins.get(cur);
            if(!nums.contains(temp[0])) {
                cur++;
                continue;
            }
            int curr = temp[0];
            int forward = temp[1];
            while(nums.contains(curr) && forward>0){
                nums.remove(curr);
                curr++;
                forward--;
            }
            ans1++;
            cur++;
        }

        posMins.clear();

        Collections.sort(prefs, new Comparator<Prefs>() {
            @Override
            public int compare(Prefs o1, Prefs o2) {
                return o2.max-o1.max;
            }
        });

        for(int i = prefs.size()-1; i>=0; i--){
            Prefs t = prefs.get(i);
            int curMax = t.min;
            int j = i-1;
            int same = 1;
            while(j>=0 && prefs.get(j).max>=curMax) {
                j--;
                same++;
            }
            posMins.add(new int[]{i, same});
        }

        Collections.sort(posMins, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        int ans2 = 0;

        HashSet<Integer> n = new HashSet<>();
        for(int i = 0; i<N; i++)
            n.add(i);

        int cu = 0;
        while(!n.isEmpty()){
            int[] temp = posMins.get(cu);
            if(!n.contains(temp[0])) {
                cu++;
                continue;
            }
            int curr = temp[0];
            int forward = temp[1];
            while(n.contains(curr) && forward>0){
                n.remove(curr);
                curr--;
                forward--;
            }
            ans2++;
            cu++;
        }

        System.out.print(Math.min(ans1, ans2));

    }

}

class Prefs{

    int min;
    int max;

    public Prefs(int min, int max){
        this.min = min;
        this.max = max;
    }

}
