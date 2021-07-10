import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Comparators {
    static int tot1 = 0;
    static int tot2 = 0;
    public static void main(String[] args) {

        String[] sentences = {"hudig oregh soirjgohi", "iduh iuhsef woehry", "aiuhgo orghiu orgsuh", "aouhg sourghoiuh awoiuho"};

        Arrays.sort(sentences, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                tot1 = 0; tot2 = 0;
                String temp1 = (o1.split(" "))[0];
                String temp2 = (o2.split(" "))[0];
                temp1.chars().forEach(i -> tot1+=i);
                temp2.chars().forEach(i -> tot2+=i);
                return tot1-tot2;
            }
        });

    }

}

class Johns implements Comparable{

    final String speaks = "No Johns";
    int height;

    public Johns(int height){
        this.height = height;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Johns){
            return this.height-((Johns) o).height;
        }
        return -1;
    }
}
