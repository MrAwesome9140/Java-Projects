import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class day {

    static ArrayList<ArrayList<Double>> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new File("day.dat"));
        int n = sc.nextInt();
        for(int i = 0; i<n; i++){
            int x = sc.nextInt();
            double[][] probs = new double[x][x];
            for(int j = 0; j<x; j++){
                ans.add(new ArrayList<>());
                for(int t = 0; t<x; t++){
                    probs[j][t] = sc.nextDouble();
                }
            }
            int k = sc.nextInt(), d = sc.nextInt();
            if(d==0){
                for(int t = 0; t<x; t++){
                    if(t==k)
                        System.out.print("1.000");
                    else
                        System.out.print("0.000");
                    if(t!=x-1)
                        System.out.print(" ");
                }
                System.out.println();
            }
            else {
                solve(probs, d - 1, k, 1);
                for (int t = 0; t < ans.size(); t++) {
                    ArrayList<Double> p = ans.get(t);
                    double sum = 0.0;
                    for (double ab : p)
                        sum += ab;
                    System.out.printf("%.3f", sum);
                    if (t != ans.size() - 1)
                        System.out.print(" ");
                }
                System.out.println();
            }
        }

    }

    static void solve(double[][] probs, int d, int workout, double prob){
        if(d==0){
            for(int i = 0; i<probs.length; i++){
                ans.get(i).add(prob*probs[workout][i]);
            }
            return;
        }
        else{
            for(int i = 0; i<probs.length; i++){
                solve(probs, d-1, i, prob*probs[workout][i]);
            }
        }
    }

}
