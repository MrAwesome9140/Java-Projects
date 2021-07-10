
import java.util.*;
import java.io.*;

public class tempcereal {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new FileReader(new File("cereal.in")));
        String[] wow = br.readLine().split(" ");

        int N = Integer.parseInt(wow[0]);
        int M = Integer.parseInt(wow[1]);

        HashSet<Integer> usedCereals = new HashSet<>();

        LinkedList<Preferences2> q = new LinkedList<>();

        for(int i = 0; i<N; i++){
            String[] strings = br.readLine().split(" ");
            Preferences2 p = new Preferences2(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]));
            q.offer(p);
        }

        br.close();

        ArrayList<Integer> answers = new ArrayList<>();
        for(int i = 0; i<N; i++){
            LinkedList<Preferences2> usedQ = (LinkedList<Preferences2>) q.clone();
            int currentCow = 0;
            int sats = 0;
            while(currentCow<N){
                if(currentCow<i){
                    usedQ.poll();
                    currentCow++;
                }
                else{
                    Preferences2 temp = usedQ.pollFirst();
                    if(!usedCereals.contains(temp.firstPref)){
                        usedCereals.add(temp.firstPref);
                        sats++;
                    }
                    else if(!usedCereals.contains(temp.secondPref)){
                        usedCereals.add(temp.secondPref);
                        sats++;
                    }
                    currentCow++;
                }
            }
            usedCereals.clear();
            answers.add(sats);
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("cereal.out")));
        for(Integer i:answers){
            bw.write(String.valueOf(i)+"\n");
        }
        bw.close();


    }

}

class Preferences2{
    int firstPref;
    int secondPref;

    public Preferences2(int firstPref, int secondPref){
        this.firstPref = firstPref;
        this.secondPref = secondPref;
    }
}
