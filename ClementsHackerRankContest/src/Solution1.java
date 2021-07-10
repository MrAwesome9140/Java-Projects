import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int numDif = 0;
        ArrayList<String> found = new ArrayList<>();
        for(int i = 0; i<n; i++){
            String temp = sc.nextLine();
            if(!found.contains(temp)){
                found.add(temp);
                numDif++;
            }
        }
        System.out.print(numDif);

    }

}
