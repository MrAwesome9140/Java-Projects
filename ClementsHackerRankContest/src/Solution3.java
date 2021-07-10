import java.util.Scanner;

public class Solution3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int large = 0;
        int large2 = 0;
        int large3 = 0;
        for(int i = 0; i<n; i++){
            int temp = sc.nextInt();
            if(temp>large){
                int t = large;
                large = temp;
                if(t>large2){
                    int k = large2;
                    large2 = t;
                    if(k>large3){
                        large3 = k;
                    }
                }
            }
            else if(temp>large2){
                int k = large2;
                large2 = temp;
                if(k>large3){
                    large3 = k;
                }
            }
            else if(temp>large3){
                large3 = temp;
            }
        }
        System.out.print((large+large2+large3));

    }

}
