import java.util.*;
import java.io.*;

public class cereal {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new FileReader(new File("cereal.in")));
        String[] wow = br.readLine().split(" ");

        int N = Integer.parseInt(wow[0]);
        int M = Integer.parseInt(wow[1]);

        HashMap<Integer, Integer> usedCereals = new HashMap<>();

        LinkedList<Preferences> q = new LinkedList<>();

        for(int i = 0; i<N; i++){
            String[] strings = br.readLine().split(" ");
            Preferences p = new Preferences(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]));
            q.offer(p);
        }

        br.close();
        HashMap<Preferences, ArrayList<Integer>> failures = new HashMap<>();
        ArrayList<Integer> answers = new ArrayList<>();
        int useThis = 0;
        for(int i = 0; i<N; i++){
            LinkedList<Preferences> usedQ = (LinkedList<Preferences>) q.clone();
            int currentCow = i;
            int sats = 0;
            if(i==0) {
                while (currentCow < N) {
                    Preferences temp = usedQ.get(currentCow);
                    if (!usedCereals.keySet().contains(temp.firstPref)) {
                        usedCereals.put(temp.firstPref, currentCow);
                        sats++;
                    } else if (!usedCereals.keySet().contains(temp.secondPref)) {
                        usedCereals.put(temp.secondPref, currentCow);
                        sats++;
                    } else {
                        ArrayList<Integer> enemies = new ArrayList<>();
                        enemies.add(usedCereals.get(temp.firstPref));
                        enemies.add(usedCereals.get(temp.secondPref));
                        failures.put(temp, enemies);
                    }
                    currentCow++;
                }
                useThis = sats;
            }
            else{
                HashMap<Integer, Integer> temp = new HashMap<>();
                sats = useThis-i;
                boolean worksNow = false;
                for(int k = 0; k<failures.keySet().toArray().length && !worksNow; k++){
                    Object[] prefed = failures.keySet().toArray();
                    Preferences p = (Preferences) prefed[k];
                    ArrayList<Integer> fails = failures.get(p);
                    int addIt = 0;
                    for(int t = 0; t<fails.size(); t++){
                        if(fails.get(t)<i) {
                            if(t==0 && !temp.containsValue(p.firstPref)){
                                addIt++;
                                worksNow = true;
                                temp.put(fails.get(t), p.firstPref);
                            }
                            else if(t==1 && !temp.containsValue(p.secondPref)){
                                addIt++;
                                worksNow = true;
                                temp.put(fails.get(t), p.secondPref);
                            }
                        }
                    }
                    if(worksNow)
                        sats+=addIt;
                }
            }
            answers.add(sats);
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("cereal.out")));
        for(int i = 0; i<answers.size(); i++){
            bw.write(String.valueOf(answers.get(i))+"\n");
        }
        bw.close();


    }

}

class Preferences{
    int firstPref;
    int secondPref;

    public Preferences(int firstPref, int secondPref){
        this.firstPref = firstPref;
        this.secondPref = secondPref;
    }
}
