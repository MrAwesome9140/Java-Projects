import java.util.Scanner;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class prob27 {

    public static void main(String[] args) throws ScriptException {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if(solve(s)){
            for(int i = 0; i<s.length(); i++){
                if(s.charAt(i)=='T')
                    System.out.println("4 E");
                else if(s.charAt(i)=='&')
                    System.out.println("2 W");
                else if(s.charAt(i)=='!')
                    System.out.println("1 N");
                else if(s.charAt(i)=='F')
                    System.out.println("JUMP");
                else if(s.charAt(i)=='|')
                    System.out.println("3 S");
            }
        }
        else{
            System.out.println("I am disinclined to acquiesce to your request");
        }
    }

    static boolean solve(String s) throws ScriptException {
        String temp = s;
        temp = temp.replaceAll("T", "(0==0)");
        temp = temp.replaceAll("F", "(0==1)");
        temp = temp.replaceAll("&", "&&");
        temp = temp.replaceAll("\\|", "||");
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine se = sem.getEngineByName("JavaScript");
        boolean te = (boolean)se.eval(temp);
        if(te)
            return true;
        else
            return false;
    }

}
