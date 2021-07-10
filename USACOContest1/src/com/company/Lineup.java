package com.company;
import java.io.*;
import java.util.*;

public class Lineup {

    public static void main(String[] args) throws IOException{

        ArrayList<String> names = new ArrayList<>();
        names.add("Bessie");
        names.add("Buttercup");
        names.add("Belinda");
        names.add("Beatrice");
        names.add("Bella");
        names.add("Blue");
        names.add("Betsy");
        names.add("Sue");

        Scanner sc = new Scanner(new File("lineup.in"));
        int i = Integer.parseInt(sc.nextLine());
        String[] vals = new String[i];
        int temp = 0;
        while(sc.hasNextLine()){
            String j = sc.nextLine();
            String[] hi = j.split(" ");
            String wow = hi[0] + " " + hi[hi.length-1];
            vals[temp] = wow;
            temp++;
        }

        Collections.sort(names);

        for(String s:vals){
            String j = "";
            String[] name = s.split(" ");
            String near = name[1];
            String near2 = name[0];
            if(names.indexOf(near)+1==names.indexOf(near2) || names.indexOf(near)-1==names.indexOf(near2)){
                if(near.compareTo(near2)<0)
                    names.set(names.indexOf(near), near + " " + near2);
                else
                    names.set(names.indexOf(near), near2 + " " + near);
            }
            else{
                if (near.compareTo(near2) < 0) {
                    String added = "";
                    String compare = "";
                    for (String g : names) {
                        String[] ok = g.split(" ");
                        for (String h : ok) {
                            if (h.equals(near)) {
                                added = g;
                                for (String u : ok) {
                                    if (!u.equals(near))
                                        compare = u;
                                }
                            }
                        }
                    }
                    String add = "";
                    if (compare.compareTo(near2) < 0) {
                        add = compare + " " + near + " " + near2;
                    } else {
                        add = near2 + " " + near + " " + compare;
                    }
                    if (names.indexOf(added) >= 0)
                        names.set(names.indexOf(added), add);
                    j = near + " " + near2;
                } else {
                    String added = "";
                    String compare = "";
                    for (String g : names) {
                        String[] ok = g.split(" ");
                        for (String h : ok) {
                            if (h.equals(near)) {
                                added = g;
                                for (String u : ok) {
                                    if (!u.equals(near))
                                        compare = u;
                                }
                            }
                        }
                    }
                    String add = "";
                    if (compare.compareTo(near2) < 0) {
                        add = compare + " " + near + " " + near2;
                    } else {
                        add = near2 + " " + near + " " + compare;
                    }
                    if (names.indexOf(added) >= 0)
                        names.set(names.indexOf(added), add);
                    j = near2 + " " + near;
                }

            }
        }

        for(String s: vals){
            String[] hi = s.split(" ");
            String test = hi[0];
            names.remove(test);
        }

        for(String j:vals){
            boolean isTrue = true;
            int counter = 0;
            String[] strings = j.split(" ");
            for(String s:names){
                String[] right = s.split(" ");
                for(String t:right){
                    if(t.equals(strings[0]) && counter<=0){
                        counter++;
                    }
                    else if(t.equals(strings[0]) && counter>0){
                        isTrue = !isTrue;
                    }
                }
            }
            List<String> useful = new ArrayList<>();
            if(!isTrue) {
                for (String y : names) {
                    String[] use = y.split(" ");
                    for (String f : use) {
                        if (f.equals(strings[0])) {
                            useful.add(y);
                        }
                    }
                }

                String no = "";
                for (String w : useful) {
                    no += w + " ";
                }
                boolean removed = false;
                String[] okay = no.split(" ");
                for (int k = 0; k < okay.length && !removed; k++) {
                    if (okay[k].equals(strings[0])) {
                        okay[k] = "";
                        removed = true;
                    }
                }
                ArrayList<String> temps = new ArrayList<>();
                for (String w : okay) {
                    temps.add(w);
                }
                for (int iq = 0; iq < temps.size(); iq++) {
                    if (temps.get(iq).equals("") || temps.get(iq).equals(" ")) {
                        temps.remove(iq);
                        iq--;
                    }
                }
                for(String w:temps){
                    if(w.equals(strings[0]) && temps.indexOf(strings[0])!=temps.size()/2){
                        swap(temps,temps.size()/2, temps.indexOf(strings[0]));
                    }
                }
                if (temps.get(0).compareTo(temps.get(temps.size()-1)) > 0)
                {
                    swap(temps, 0, temps.size()-1);
                }
                boolean replace = false;
                for (int t = 0; t < names.size() && !replace; t++) {
                    String[] hi = names.get(t).split(" ");
                    if (names.get(t).contains(strings[0])) {
                        String u = "";
                        for (String f : temps) {
                            u += f + " ";
                        }
                        names.set(t, u);
                        replace = true;
                    }
                }
            }
        }

        Collections.sort(names);

        List<String> adder = new ArrayList<>();
        for(int p = 0;p<names.size();p++){
            String[] t = names.get(p).split(" ");
            for(String y:t){
                if(!adder.contains(y)){
                    adder.add(y);
                }
            }
        }

        FileWriter fw = new FileWriter(new File("lineup.out"));
        for(String s:adder){
            if(!s.equals("") && !s.equals(" "))
                fw.append(s+"\n");
        }
        fw.flush();
        fw.close();


    }

    public static void swap(ArrayList<String> hi, int index1, int index2){
        String temp = hi.get(index1);
        hi.set(index1, hi.get(index2));
        hi.set(index2, temp);
    }

}
