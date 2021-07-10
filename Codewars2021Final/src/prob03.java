import java.util.Scanner;

public class prob03 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s;
        int y = 0;
        boolean bre = false;
        while(sc.hasNextLine()){
            s=sc.nextLine();
            for(int i = 0; i<s.length(); i++){
                if(s.charAt(i)=='P') {
                    System.out.print("Ace, move fast, pigeon is at (" + i + ", " + y + ")");
                    bre = true;
                    break;
                }
            }
            y++;
            if(bre)
                break;
        }
        if(!bre)
            System.out.print("No pigeon, try another map, Ace");
    }

}
