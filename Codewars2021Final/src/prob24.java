import java.util.Scanner;

public class prob24 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String translate = sc.nextLine();
        String decoder = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<translate.length(); i++){
            sb.append(decoder.charAt(translate.charAt(i)-32));
        }
        System.out.println(sb);
    }

}
