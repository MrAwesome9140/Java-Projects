/*
ID: aaroh.sh
LANG: JAVA
TASK: namenum
*/

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class namenum {

    private static ArrayList<String> validNames = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader textReader = new BufferedReader(new FileReader(new File("dict.txt")));
        ArrayList<String> names = new ArrayList<>();

        String s = "";

        while((s=textReader.readLine())!=null)
            names.add(s);

        textReader.close();

        HashMap<Integer, String> vals = new HashMap<>();


        vals.put(2, "A B C");
        vals.put(3, "D E F");
        vals.put(4, "G H I");
        vals.put(5, "J K L");
        vals.put(6, "M N O");
        vals.put(7, "P R S");
        vals.put(8, "T U V");
        vals.put(9, "W X Y");

        BufferedReader br = new BufferedReader(new FileReader(new File("namenum.in")));
        Long num = Long.parseLong(br.readLine());

        char[] digits = String.valueOf(num).toCharArray();

        for(String t: names){
            StringBuffer buff = new StringBuffer();
            for(int i = 0; i<t.length(); i++){
                buff.append(String.valueOf(convertToNum(t.charAt(i))));
            }
            if(Long.parseLong(buff.toString())==num){
                validNames.add(t);
            }
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("namenum.out")));
        if(validNames.size()>0) {
            for (String t : validNames) {
                bw.write(t + "\n");
            }
        }
        else{
            bw.write("NONE" + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static int convertToNum(char c){
        switch(c){
            case 'A': case'B': case'C': return 2;
            case 'D': case'E': case'F': return 3;
            case 'G': case'H': case'I': return 4;
            case 'J': case'K': case'L': return 5;
            case 'M': case'N': case'O': return 6;
            case 'P': case'R': case'S': return 7;
            case 'T': case'U': case'V': return 8;
            case 'W': case'X': case'Y': return 9;
        }
        return 0;
    }

}
