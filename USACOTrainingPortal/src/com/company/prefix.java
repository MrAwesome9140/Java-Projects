/*
ID: aaroh.sh
LANG: JAVA
TASK: prefix
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class prefix {

    static ArrayList<String> words;
    static int maxLength;
    static String originalString;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new FileReader(new File("prefix.in")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("prefix.out")));

        String[] temp = br.readLine().split("\\s++");
        words = new ArrayList<>();

        while(!temp[0].equals(".")){
            words.addAll(Arrays.asList(temp));
            temp = br.readLine().split("\\s++");
        }


        words.forEach((s) -> maxLength = Math.max(maxLength, s.length()));

        String word = "";

        String s;
        while((s = br.readLine())!=null){
            word+=s;
        }

        originalString = word;

        ArrayList<String> temps = new ArrayList<>();

        bw.write(String.valueOf(solve(word)));
        bw.newLine();
        bw.close();
    }

    static int solve(String word){
        int currIndex = 0;
        ArrayList<Integer> endInd = new ArrayList<>();
        ArrayList<String> maxWord = new ArrayList<>();
        String curr = word.substring(0,currIndex+1);
        while(curr.length()<=maxLength && currIndex<word.length()){
            if(words.contains(curr)){
                endInd.add(currIndex);
                maxWord.add(curr);
            }
            currIndex++;
            if(currIndex<word.length())
                curr = word.substring(0,currIndex+1);
        }
        int answer = 0;
        if(maxWord.size()>0) {
            for(int i = 0; i<endInd.size(); i++){
                String temps = word.substring(endInd.get(i)+1);
                if(temps.length()>0)
                    answer = Math.max(answer, maxWord.get(i).length()+solve(temps));
                else
                    answer = 1;
            }
            return answer;
        }
        else
            return 0;
    }

}
