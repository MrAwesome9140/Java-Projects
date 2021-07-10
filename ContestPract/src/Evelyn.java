import java.lang.*;
import java.util.*;
import java.io.*;

public class Evelyn {

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new FileReader("Evelyn.in"));
        List<Integer> vals = new ArrayList<>();
        String s = "";
        while((s = bf.readLine())!=null){
            vals.add(Integer.parseInt(s));
        }
        for(int p:vals){
            List<Character> chars = new ArrayList<Character>();
            int[] nums = new int[p+1];
            for(int i = 0; i<nums.length;i++){
                if(i<2)
                    nums[i]=1;
                else
                    nums[i]=nums[i-1]+nums[i-2];
                String g = String.valueOf(nums[i]);
                char[] c = g.toCharArray();
                for(int x = 0;x<c.length;x++){
                    changeSystem(c,x);
                    chars.add(c[x]);
                }
            }
            for(char c:chars)
                System.out.print(c+" ");
            System.out.println();
        }
    }

    public static void changeSystem(char[] c, int x){
        switch(c[x]) {
            case '0':
                c[x] = '&';
                break;
            case '1':
                c[x] = '\'';
                break;
            case '2':
                c[x] = '(';
                break;
            case '3':
                c[x] = ')';
                break;
            case '4':
                c[x] = '*';
                break;
            case '5':
                c[x] = '+';
                break;
            case '6':
                c[x] = ',';
                break;
            case '7':
                c[x] = '-';
                break;
            case '8':
                c[x] = '.';
                break;
            case '9':
                c[x] = '/';
                break;
        }
    }

}
