import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class armleg {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("armleg.dat")));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i<n; i++){
            String[] nums = br.readLine().split(" ");
            int x = Integer.parseInt(nums[0]);
            int y = Integer.parseInt(nums[1]);
            int k = Integer.parseInt(nums[2]);
            for(int j = 1; j<=k; j++){
                if(j%x==0 && j%y==0)
                    System.out.println("ArmLeg");
                else if(j%x==0)
                    System.out.println("Arm");
                else if(j%y==0)
                    System.out.println("Leg");
                else
                    System.out.println(j);
            }
            if(i!=n-1)
                System.out.println();
        }


    }

}
