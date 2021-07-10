import java.util.Scanner;

public class prob06 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)==' ')
                sb.append(" ");
            else{
                char replace;
                if(s.charAt(i)<'F')
                    replace = (char)(s.charAt(i)+21);
                else
                    replace = (char)(s.charAt(i)-5);
                sb.append(replace);
            }
        }
        System.out.print(sb);

    }

}
