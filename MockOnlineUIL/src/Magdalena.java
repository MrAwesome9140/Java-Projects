import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Magdalena {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("magdalena.dat")));

        int T = Integer.parseInt(br.readLine());

        for(int p = 0; p<T; p++){
            String[] temp = br.readLine().split(" ");
            int B = Integer.parseInt(temp[0]);
            String X = temp[1];

            char[] vals = X.toCharArray();

            int sum = 0;

            int temper = 1;
            for(char c:vals){
                int val = (int)c;
                if(val>=48 && val<=57){
                    sum+=(val-48)*(int) Math.pow(B,vals.length-temper);
                }
                else if(val>=65 && val<=90){
                    sum+=(val-55)*(int) Math.pow(B,vals.length-temper);
                }
                else{
                    sum+=(val-61)*(int) Math.pow(B,vals.length-temper);
                }
                temper--;
            }
            String ans = toBaseB(B, sum);
            System.out.println("Case #"+(p+1)+": "+ans);
        }

    }

    static String toBaseB(int B, int sum){
        int pow = 1;
        while(Math.pow(B,pow)<=sum)
            pow++;
        pow--;
        String used = "";
        while(sum>0){
            int howMany = sum/(int)Math.pow(B,pow);
            sum%=(int) Math.pow(B,pow);
            if(howMany>=0 && howMany<=9){
                used+=String.valueOf(howMany);
            }
            else if(howMany>=10 && howMany<=35){
                used+=String.valueOf((char) (howMany+55));
            }
            else{
                used+=String.valueOf((char) (howMany+61));
            }
        }
        return used;
    }

}
