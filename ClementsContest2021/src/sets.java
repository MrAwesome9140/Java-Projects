import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class sets {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new File("sets.dat"));
        sc.nextInt();
        sc.nextLine();
        while(sc.hasNextLine()){
            String[] temp = sc.nextLine().split(" ");
            int sets = Integer.parseInt(temp[0]);
            int reps = Integer.parseInt(temp[1]);
            for(int i = 1; i<=sets; i++) {
                for (int j = 1; j <= reps; j++) {
                    System.out.println("set " + i + " rep " + j);
                }
            }
            if(sc.hasNextLine())
                System.out.println();
        }

    }

}
