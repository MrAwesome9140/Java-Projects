import java.util.*;

public class prob15 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> prio = new HashMap<>();
        prio.put("Garnet", 1);
        prio.put("Amethyst", 2);
        prio.put("Aquamarine", 3);
        prio.put("Diamond", 4);
        prio.put("Emerald", 5);
        prio.put("Pearl", 6);
        prio.put("Ruby", 7);
        prio.put("Peridot", 8);
        prio.put("Sapphire", 9);
        prio.put("Tourmaline", 10);
        prio.put("Topaz", 11);
        prio.put("Lapis", 12);
        ArrayList<Gems> gems = new ArrayList<>();
        ArrayList<String> nonGems = new ArrayList<>();
        String s;
        while(!(s=sc.nextLine()).equals("END")){
            String[] temp = s.split(" ");
            int val = -1;
            if(temp.length>1){
                boolean co0 = prio.containsKey(temp[0]);
                boolean co1 = prio.containsKey(temp[1]);
                if(co0 && co1)
                    val = Math.max(prio.get(temp[0]), prio.get(temp[1]));
                else if(co0)
                    val = prio.get(temp[0]);
                else if(co1)
                    val = prio.get(temp[1]);
            }
            else{
                if(prio.containsKey(temp[0]))
                    val = prio.get(temp[0]);
            }

            if(val==-1)
                nonGems.add(s);
            else{
                gems.add(new Gems(val, s));
            }
        }
        Collections.sort(nonGems);
        Collections.sort(gems, new Comparator<Gems>() {
            @Override
            public int compare(Gems o1, Gems o2) {
                return o1.val!=o2.val?o2.val-o1.val:o1.gem.compareTo(o2.gem);
            }
        });
        for(Gems g:gems)
            System.out.println(g.gem);
        for(String t:nonGems)
            System.out.println(t);

    }

}

class Gems{
    int val;
    String gem;
    public Gems(int val, String gem){
        this.val = val;
        this.gem = gem;
    }
}
