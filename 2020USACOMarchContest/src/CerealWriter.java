import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class CerealWriter {

    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("cereal.in")));
        bw.write("8 19\n");
        Random r = new Random();

        for(int i = 0; i<8; i++){
            bw.write(String.valueOf(r.nextInt(20)) + " " + String.valueOf(r.nextInt(20)) + "\n");
        }

        bw.close();

    }

}
