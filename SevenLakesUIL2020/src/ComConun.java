import java.util.ArrayList;
import java.util.Scanner;

public class ComConun {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        for(int i = 0; i<N; i++){
            String name = sc.nextLine();
            StringBuffer sb = new StringBuffer(name);
            int sents = Integer.parseInt(sc.nextLine());
            ArrayList<String> sent = new ArrayList<>();
            int maxLen = 0;
            for(int k = 0; k<sents; k++){
                String temp = sc.nextLine();
                sent.add(temp);
                maxLen = Math.max(maxLen, temp.length());
            }
            StringBuffer totName = new StringBuffer();
            while(totName.length()<maxLen){
                totName.append(sb.toString());
                char temp = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(temp);
            }
            char[] nameChars = totName.toString().toCharArray();
            for(String s:sent){
                int curLetter = 0;
                StringBuffer sol = new StringBuffer();
                char[] chars = s.toCharArray();
                for(int k = 0; k<chars.length; k++){
                    int ascii = chars[k];
                    if(!((ascii>=65 && ascii<=90) || (ascii>=97 && ascii<=122))){
                        sol.append(chars[k]);
                    }
                    else if(ascii<=90){
                        ascii -= convertNum(nameChars[curLetter]);
                        //System.out.println((int)nameChars[curLetter]);
                        //System.out.println("Ascii: " + ascii);
                        if(ascii<65){
                            ascii = 90-(64-ascii);
                        }
                        sol.append(((char)ascii));
                        curLetter++;
                    }
                    else{
                        ascii -= convertNum(nameChars[curLetter]);
                        //System.out.println((int)nameChars[curLetter]);
                        //System.out.println("Ascii: " + ascii);
                        if(ascii<97){
                            ascii = 122-(96-ascii);
                        }
                        sol.append(((char)ascii));
                        curLetter++;
                    }
                }
                System.out.println(sol.toString());
            }
            if(i!=N-1)
                System.out.println();
        }

    }

    static char convertNum(char c){
        if(c<=90){
            return (char)(c-65);
        }
        return (char)(c-97);
    }

}
