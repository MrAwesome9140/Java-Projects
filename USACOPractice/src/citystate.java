import java.io.*;
import java.util.*;

public class citystate {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new FileReader(new File("citystate.in")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("citystate.out")));

        int n = Integer.parseInt(br.readLine());
        HashMap<String, HashSet<String>> pairs = new HashMap<>();
        HashMap<String, HashSet<String>> firstTwo = new HashMap<>();
        HashMap<String, String> match = new HashMap<>();
        for(int i = 0; i<n; i++){
            String[] t = br.readLine().split(" ");
            String city = t[0];
            String state = t[1];
            String two = city.substring(0, 2);
            if(firstTwo.containsKey(two))
                firstTwo.get(two).add(city);
            else{
                HashSet<String> temp = new HashSet<>();
                temp.add(city);
                firstTwo.put(two, temp);
            }

            if(pairs.containsKey(state))
                pairs.get(state).add(city);
            else{
                HashSet<String> temp = new HashSet<>();
                temp.add(city);
                pairs.put(state, temp);
            }
        }

        for(String s:firstTwo.keySet()){
            HashSet<String> temp = new HashSet<>();
            if((temp=pairs.get(s))!=null){

            }
        }

    }

}
