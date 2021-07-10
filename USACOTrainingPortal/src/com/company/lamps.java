/*
ID: aaroh.sh
LANG: JAVA
TASK: lamps
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Stream;

public class lamps {

    static ArrayList<String> vals;
    static int[] ons;
    static int[] offs;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new FileReader(new File("lamps.in")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("lamps.out")));

        vals = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        int finalC = Integer.parseInt(br.readLine());

        String[] t = br.readLine().split("\\s++");

        ons = new int[t.length-1];

        for(int i = 0; i<t.length-1; i++){
            ons[i] = Integer.parseInt(t[i]);
        }

        String[] t2 = br.readLine().split("\\s++");

        offs = new int[t2.length-1];

        for(int i = 0; i<t2.length-1; i++){
            offs[i] = Integer.parseInt(t2[i]);
        }

        String start = "";
        for(int i = 0; i<N; i++)
            start+='1';

        for(int i = 1; i<=4; i++){
            solve(Math.min(3,finalC), i, 0, new StringBuilder(start));
        }

        if(vals.isEmpty())
            bw.write("IMPOSSIBLE\n");
        else {
            Collections.sort(vals, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            vals.forEach((s) -> {
                try {
                    bw.write(s);
                    bw.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

        bw.close();

    }

    static void solve(int finalC, int curButton, int curC, StringBuilder tempString){
        String temp = tempString.toString();
        if(curC == finalC && ((ons.length==0 && offs.length==0) || satisfied(temp)) && (vals.isEmpty() || !vals.contains(temp))) {
            vals.add(temp);
            return;
        }
        if(curC == finalC){
            return;
        }
        else{
            tempString = new StringBuilder(buttons(curButton, temp));
            curC++;
            for(int i = 1; i<=4; i++){
                solve(finalC, i, curC, tempString);
            }
        }
    }

    static boolean satisfied(String test){
        for(int i:ons)
            if(test.charAt(i-1)!='1')
                return false;
        for(int i:offs)
            if(test.charAt(i-1)!='0')
                return false;
        return true;
    }

    static String buttons(int button, String use){
        switch (button){
            case 1:
                use = flipAll(use);
                break;
            case 2:
                use = flipOdds(use);
                break;
            case 3:
                use = flipEvens(use);
                break;
            case 4:
                use = flipSpecial(use);
                break;
        }
        return use;
    }

    static String flipAll(String temp){
        String ret = "";
        for(int i = 0; i<temp.length(); i++){
            if(temp.charAt(i)=='1')
                ret+='0';
            else
                ret+='1';
        }
        return ret;
    }

    static String flipOdds(String temp){
        String ret = "";
        for(int i = 0; i<temp.length(); i++){
            if(i%2==0) {
                if (temp.charAt(i) == '1')
                    ret += '0';
                else
                    ret += '1';
            }
            else
                ret += temp.charAt(i);
        }
        return ret;
    }

    static String flipEvens(String temp){
        String ret = "";
        for(int i = 0; i<temp.length(); i++){
            if(i%2!=0) {
                if (temp.charAt(i) == '1')
                    ret += '0';
                else
                    ret += '1';
            }
            else
                ret += temp.charAt(i);
        }
        return ret;
    }

    static String flipSpecial(String temp){
        String ret = "";;
        for(int i = 0; i<temp.length(); i++){
            if(i%3==0) {
                if (temp.charAt(i) == '1')
                    ret += '0';
                else
                    ret += '1';
            }
            else
                ret += temp.charAt(i);
        }
        return ret;
    }

}
