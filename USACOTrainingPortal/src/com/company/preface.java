/*
ID: aaroh.sh
LANG: JAVA
TASK: preface
*/

import java.io.*;
import java.util.*;

public class preface {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("preface.in")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("preface.out")));

        int N = Integer.parseInt(br.readLine());

        int[] vals = {1,5,10,50,100,500,1000};

        HashMap<Integer, String> useThis = new HashMap<>();
        useThis.put(1,"I");
        useThis.put(5,"V");
        useThis.put(10,"X");
        useThis.put(50,"L");
        useThis.put(100,"C");
        useThis.put(500,"D");
        useThis.put(1000,"M");

        HashMap<String, Integer> anotherOne = new HashMap<>();
        anotherOne.put("I",1);
        anotherOne.put("V",5);
        anotherOne.put("X",10);
        anotherOne.put("L",50);
        anotherOne.put("C",100);
        anotherOne.put("D",500);
        anotherOne.put("M",1000);

        HashMap<String, Integer> values = new HashMap<>();
        values.put("I", 0);
        values.put("V", 0);
        values.put("X", 0);
        values.put("L", 0);
        values.put("C", 0);
        values.put("D", 0);
        values.put("M", 0);

        for(int i = 1; i<=N; i++) {
            int temp = i;
            if(i==90)
                System.out.println();
            for (int k = vals.length - 1; k >= 0 && temp > 0; k--) {
                int num = (int) (Math.floor(temp/10.0)*10);
                if ((double)temp / vals[k] >= 0.8) {
                    if (temp == 4) {
                        values.replace("V", values.get("V") + 1);
                        values.replace("I", values.get("I") + 1);
                        temp -= 4;
                    } else if (temp == 9) {
                        values.replace("X", values.get("X") + 1);
                        values.replace("I", values.get("I") + 1);
                        temp -= 9;
                    } else if (temp >= 40 && temp<50) {
                        values.replace("L", values.get("L") + 1);
                        values.replace("X", values.get("X") + 1);
                        temp -= 40;
                    } else if (temp >= 90 && temp<100) {
                        values.replace("C", values.get("C") + 1);
                        values.replace("X", values.get("X") + 1);
                        temp -= 90;
                    } else if (temp >= 400 && temp<500) {
                        values.replace("D", values.get("D") + 1);
                        values.replace("C", values.get("C") + 1);
                        temp -= 400;
                    } else if (temp >= 900 && temp<1000) {
                        values.replace("M", values.get("M") + 1);
                        values.replace("C", values.get("C") + 1);
                        temp -= 900;
                    } else {
                        values.replace(useThis.get(vals[k]), values.get(useThis.get(vals[k])) + (temp / vals[k]));
                        temp -= ((temp / vals[k]) * vals[k]);
                    }
                }
            }
        }

        ArrayList<String> tempor = new ArrayList<>(values.keySet());

        Collections.sort(tempor, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return anotherOne.get(o1)-anotherOne.get(o2);
            }
        });

        for(String s:tempor){
            if(values.get(s)!=0){
                bw.write(s + " " + String.valueOf(values.get(s)));
                bw.newLine();
            }
        }

        bw.close();
    }

}
