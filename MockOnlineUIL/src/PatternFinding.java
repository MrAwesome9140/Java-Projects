import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PatternFinding {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("patternfinding.dat")));
        String[] temps = br.readLine().split(" ");

        int N = Integer.parseInt(temps[0]);
        int K = Integer.parseInt(temps[1]);



    }

}
