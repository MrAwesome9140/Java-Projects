import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class balance {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new File("balance.dat"));

        int i = sc.nextInt();

        for(int j = 0; j<i; j++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int cnt1 = 0, cnt2 = 0;
            for(int k = 0; k<x; k++){
                cnt1+=(2*k+29)*sc.nextInt();
            }
            for(int k = 0; k<y; k++)
                cnt2 += (2*k+29)*sc.nextInt();
            if(cnt1==cnt2)
                System.out.println("safe to lift");
            else
                System.out.println("unsafe");
        }

    }

}
