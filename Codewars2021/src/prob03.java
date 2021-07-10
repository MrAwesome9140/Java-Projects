import java.util.Scanner;

public class prob03 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s;
        StringBuffer ans = new StringBuffer();
        while(Integer.parseInt((s=sc.nextLine()))!=0){
            boolean mag = true;
            for(int i = 1; i<s.length(); i++){
                int sum = Integer.parseInt(s.substring(0, i))+Integer.parseInt(s.substring(i));
                if(!isPrime(sum)) {
                    mag = false;
                    break;
                }
            }
            if(mag)
                ans.append(s).append(" MAGNANIMOUS\n");
            else
                ans.append(s).append(" PETTY\n");
        }
        System.out.println(ans);

    }

    static boolean isPrime(int n){
        if(n==1)
            return false;
        for(int i = 2; i<=Math.sqrt(n); i++)
            if(n%i==0)
                return false;
        return true;
    }

}
