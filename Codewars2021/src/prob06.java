import java.util.Scanner;

public class prob06 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int l = Integer.parseInt(sc.nextLine());
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i<l; i++){
            String te = sc.nextLine();
            String temp = te.replaceAll("[^0-9]", "");
            boolean valid = true;
            if(Integer.parseInt(temp.substring(0,1))<2 || Integer.parseInt(temp.substring(1,2))==9 || Integer.parseInt(temp.substring(3,4))<2 || Integer.parseInt(temp.substring(4,5))==1 || Integer.parseInt(temp.substring(5,6))==1)
                valid = false;
            String appendThis = valid ? te+" VALID\n" : te+" INVALID\n";
            sb.append(appendThis);
        }
        System.out.println(sb);

    }

}
