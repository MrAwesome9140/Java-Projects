import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class meetings {

    static ArrayList<Cow> cows = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("meetings.in")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("meetings.out")));

        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int l = Integer.parseInt(temp[1]);

        for(int i = 0; i<n; i++){
            String[] te = br.readLine().split(" ");
            cows.add(new Cow(Integer.parseInt(te[0]), Integer.parseInt(te[1]), Integer.parseInt(te[2])));
        }

    }

}

class Cow{
    int weight;
    int startPos;
    int vel;

    public Cow(int weight, int startPos, int vel){
        this.weight = weight;
        this.startPos = startPos;
        this.vel = vel;
    }
}
