import java.util.Scanner;

public class prob09 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int s;
        StringBuffer sb = new StringBuffer();
        while((s=Integer.parseInt(sc.nextLine()))!=0){
            String t = Integer.toBinaryString(s);
            int num1 = 0;
            int num0 = 0;
            for(int i = 0; i<t.length(); i++){
                if(t.charAt(i)=='1')
                    num1++;
                else
                    num0++;
            }
            sb.append(s).append(" ");
            if(num1>num0)
                sb.append("HEAVY\n");
            else if(num1<num0)
                sb.append("LIGHT\n");
            else
                sb.append("BALANCED\n");
        }
        System.out.println(sb);

    }

}
