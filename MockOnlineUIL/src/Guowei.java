import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class Guowei {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new File("guowei.dat"));
        int count = Integer.parseInt(sc.nextLine());
        for(int i = 0; i<count; i++){
            int space = Integer.parseInt(sc.nextLine());
            String line = sc.nextLine();
            int chars = line.length();
            String useThis = "";
            if(space<chars)
                useThis = line.substring(space);
            else
                useThis = line.substring(space%chars-1);
            if(useThis.length()>=40)
                System.out.println(useThis.substring(0, 40));
            else{
                int doIt = 40-useThis.length()-1;
                System.out.println(useThis+" "+line.substring(0,doIt));
            }
        }
    }
}
