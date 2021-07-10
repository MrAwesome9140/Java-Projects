import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CeilDivisions {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        ArrayList<Integer> testCases = new ArrayList<>();
        for(int i = 0; i<t; i++)
            testCases.add(Integer.parseInt(br.readLine()));

        for(Integer i:testCases){
            int ans = 0;
            ArrayList<int[]> ansPairs = new ArrayList<>();
            for(int k = 3; k<i; k++){
                if(k!=64) {
                    ansPairs.add(new int[]{k, i});
                    ans++;
                }
            }
            int temp = i;
            while(temp!=1){
                ans++;
                ansPairs.add(new int[]{i, 64});
                temp = (int)Math.ceil(temp/64.0);
            }
            temp = 64;
            for(int j = 0; j<ansPairs.size(); j++)
                System.out.println(ansPairs.get(j)[0] + " " + ansPairs.get(j)[1]);
        }


    }

}
