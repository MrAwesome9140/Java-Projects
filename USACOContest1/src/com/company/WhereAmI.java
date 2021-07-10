package com.company;
import java.io.*;
import java.util.*;

public class WhereAmI {

    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(new File("whereami.in"));
        sc.nextLine();
        char[] lets = sc.nextLine().toCharArray();

        int longest = 1;
        int length = 0;
        for(int k = 2;k<lets.length;k++){
            boolean valid = true;
            int cons = 0;
            String j = "";
            for(int o = 0;o<=k-1;o++)
                j+=lets[o];
            for(int temp = k; temp<lets.length && valid; temp++){
                String v = "";
                for(int o = temp-k+1;o<=temp;o++){
                    v+=lets[o];
                }
                if(!v.equals(j)){
                    for(int y = temp-1;y>=k;y--){
                        String p = "";
                        for(int r = y-k+1;r<=y;r++){
                            p+=lets[r];
                        }
                        if(v.equals(p))
                            valid = false;
                    }
                    if(valid)
                        cons++;
                }
                else{
                    valid=false;
                }
            }
            if(cons>longest && valid) {
                longest = cons;
                length = k;
            }
        }

        FileWriter fw = new FileWriter(new File("whereami.out"));
        fw.write(String.valueOf(length));
        fw.flush();
        fw.close();

    }

}
