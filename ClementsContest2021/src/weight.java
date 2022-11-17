import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class weight {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("weight.dat"));
        int n = sc.nextInt();
        while (sc.hasNext()){
            double d = sc.nextDouble(), r1 = sc.nextDouble(), r2 = sc.nextDouble(), w = sc.nextDouble();
            double vol = d*w*Math.PI*(r1*r1-r2*r2);
            System.out.printf("%.3f\n", vol);
        }

    }

}
