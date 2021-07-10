import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Brittany {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("brittany.dat")));
        String[] doubles = br.readLine().split("\\s++");

        double sum = 0.0;
        for(int i = 0; i<doubles.length; i++){
            sum+=Double.parseDouble(doubles[i]);
        }
        double average = sum/doubles.length;

        System.out.println((Math.round(sum * 100.0) / 100.0)+" "+(Math.round(average * 100.0) / 100.0));

    }

}
