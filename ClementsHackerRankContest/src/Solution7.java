import java.util.Scanner;

public class Solution7 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] inits = sc.nextLine().split(" ");
        String[] addeds = sc.nextLine().split(" ");
        int[] initRats = new int[n];
        int[] addedScores = new int[n];
        int[] totScores = new int[n];
        int maxProb = 0;
        int maxInd = 0;
        for(int i = 0; i<n; i++){
            if(i<n-1){
                initRats[i] = Integer.parseInt(inits[i]);
                addedScores[i] = Integer.parseInt(addeds[i]);
                if(initRats[i]>maxProb){
                    maxProb = initRats[i];
                    maxInd = i;
                }
                if(i>0)
                    totScores[i] = initRats[i]+addedScores[i-1];
            }
            else{
                initRats[i] = Integer.parseInt(inits[i]);
                if(initRats[i]>maxProb){
                    maxProb = initRats[i];
                    maxInd = i;
                }
                if(i>0)
                    totScores[i] = initRats[i]+addedScores[i-1];
            }
        }
        int temp = initRats[0];
        initRats[0] = maxProb;
        initRats[maxInd] = temp;
        int maxScore = initRats[0];
        for(int i = 1; i<n; i++){
            maxScore+=initRats[i]+addedScores[i-1];
        }
        System.out.println(maxScore);

    }

}
