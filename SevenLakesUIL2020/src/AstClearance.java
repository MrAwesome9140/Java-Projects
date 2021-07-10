import java.util.Scanner;

public class AstClearance {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] temp = sc.nextLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);
        int[] asts = new int[N+1];
        int totRad = 0;
        for(int i = 1; i<=N; i++){
            int tep = Integer.parseInt(sc.nextLine());
            asts[i] = tep;
            totRad+=tep;
        }
        int optimal = (int)Math.floor((double)totRad/M);
        int tempSum = 0;
        int minX = Integer.MAX_VALUE;
        int shotsFired = 0;
        for(int i = 1; i<asts.length; i++){
            tempSum+=asts[i];
            if(tempSum>=optimal){
                minX = Math.min(minX, tempSum);
                tempSum = 0;
                shotsFired++;
                if(M-shotsFired == asts.length-1-i)
                    break;
            }
        }
        tempSum = 0;
        for(int i = asts.length-1; i>0; i--){
            tempSum+=asts[i];
            if(tempSum>=optimal){
                minX = Math.min(minX, tempSum);
                tempSum = 0;
            }
        }
        System.out.println(minX);
    }

}
