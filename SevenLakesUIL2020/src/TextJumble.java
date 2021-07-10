import java.util.ArrayList;
import java.util.Scanner;

public class TextJumble {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> inputs = new ArrayList<>();
        while(sc.hasNextLine()){
            inputs.add(sc.nextLine());
        }

        ArrayList<String> sols = new ArrayList<>();
        for(String s:inputs){
            char[] temp = s.toCharArray();
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i<temp.length-1; i++){
                if(temp[i]!=';')
                    sb.append(temp[i]);
            }
            sb.append(";");
            sols.add(sb.toString());
        }
        for(String s:sols){
            System.out.println(s);
        }

    }

}
