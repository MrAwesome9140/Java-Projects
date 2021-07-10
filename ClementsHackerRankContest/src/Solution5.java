import java.util.Scanner;

public class Solution5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int maxScore = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            int temp = sc.nextInt();
            if(temp>maxScore){
                maxScore = temp;
                System.out.println(maxScore);
            }
        }

    }

}
