import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class changpu {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("changpu.dat")));
        String[] s = br.readLine().split(" ");
        for(String temp: s){
            int i = Integer.parseInt(temp);
            int oNum = i%2==0 ? -(i+1) : -i;
            System.out.println(i+" "+oNum);
        }
    }

}
