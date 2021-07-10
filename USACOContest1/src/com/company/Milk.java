package com.company;
import java.io.*;
import java.util.*;
public class Milk {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("lineup.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<String> names = new ArrayList<>();
        names.add("Beatrice");
        names.add("Belinda");
        names.add("Bella");
        names.add("Bessy");
        names.add("Betsy");
        names.add("Blue");
        names.add("Buttercup");
        names.add("Sue");
        ArrayList<String> used = new ArrayList<>();
        for(int x = 0;x<n;x++)
        {
            String b = br.readLine();
            String first = b.replaceFirst("must be milked beside", "");
            String[] z = first.split(" ");
            Arrays.sort(z);
            if(z[0].compareTo(z[1])<0 && !used.contains(z[1]))
            {
                String temp = z[0];

                int index=0;
                for (int k=0; k<names.size(); k++){
                    if(names.get(k).equals(temp)){
                        index = k;
                        break;
                    }
                }

                names.add(index+1, z[1]);
                System.out.println(names);
                names.remove(names.lastIndexOf(z[1]));
            }
            else if(used.contains(z[1]) || used.contains(z[0]))
            {
                String temp = z[0];

                int index=0;
                for (int k=0; k<names.size(); k++){
                    if(names.get(k).equals(temp)){
                        index = k;
                        break;
                    }
                }

                names.add(index, z[1]);
                System.out.println(names);
                names.remove(names.lastIndexOf(z[1]));
            }
            else
            {
                String temp = z[1];
                int index=0;
                for (int k=0; k<names.size(); k++){
                    if(names.get(k).equals(temp)){
                        index = k;
                        break;
                    }
                }
                names.add(index+1, z[0]);
                System.out.println(names);
                names.remove(names.lastIndexOf(z[0]));
            }
            for(int i=0;i<2;i++)
            {
                used.add(z[i]);
            }
        }
        for(int i=0;i<names.size();i++)
        {
            pw.println(names.get(i));
        }
        pw.close();
    }
}