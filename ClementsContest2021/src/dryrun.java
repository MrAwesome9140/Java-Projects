import java.util.*;
import java.io.*;

public class dryrun {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new File("dryrun.in"));
        int numberPiles = in.nextInt();

        int presents = 0;
        for(int i = 0; i<numberPiles; i++)
            presents += in.nextInt();
        System.out.println(presents);

    }

}
