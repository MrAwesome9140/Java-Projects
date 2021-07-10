import java.io.File;
import java.io.IOException;
import java.util.*;

public class Seema {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("seema.dat"));
        String x = sc.nextLine();
        ArrayList<String> used = new ArrayList<>();
        ArrayList<Integer> counts = new ArrayList<>();
        String[] memes = x.split(",");
        used.add(memes[0]);
        counts.add(1);
        for(int j =1;j<memes.length;j++)
        {
            boolean new1 = true;
            for(int i = 0;i<used.size();i++)
                if(memes[j].equals(used.get(i))) {
                    counts.set(i, counts.get(i) + 1);
                    new1=false;
                }
            if(new1)
            {
                used.add(memes[j]);
                counts.add(1);
            }
        }
        HashMap<Integer, String> vals = new HashMap<>();
        for(int i = 0; i<used.size(); i++){
            vals.put(counts.get(i), used.get(i));
        }
        Collections.sort(used);
        Collections.sort(counts, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return vals.get(o1).compareTo(vals.get(o2));
            }
        });

        for(int i = 0;i<used.size();i++)
            System.out.print(used.get(i) + " " + counts.get(i));
    }
}
