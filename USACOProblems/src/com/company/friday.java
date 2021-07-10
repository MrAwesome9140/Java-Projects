/*
ID: aaroh.s1
TASK: friday
LANG: JAVA
*/

package com.company;

import java.io.*;
import java.util.Calendar;

public class friday {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new FileReader("friday.in"));
        int n = Integer.parseInt(bf.readLine());
        int Sundays = 0;
        int Mondays = 0;
        int Tuesdays = 0;
        int Wednesdays = 0;
        int Thursdays = 0;
        int Fridays = 0;
        int Saturdays = 0;
        Calendar cal;
        for(int i = 1900; i<1900+n; i++) {
            for(int x = 0; x<12; x++) {
                cal = new Calendar.Builder().setFields(Calendar.YEAR, i,
                        Calendar.MONTH, x,
                        Calendar.DATE, 13).build();
                switch(cal.get(Calendar.DAY_OF_WEEK)) {
                    case 1:
                        Sundays++;
                        break;
                    case 2:
                        Mondays++;
                        break;
                    case 3:
                        Tuesdays++;
                        break;
                    case 4:
                        Wednesdays++;
                        break;
                    case 5:
                        Thursdays++;
                        break;
                    case 6:
                        Fridays++;
                        break;
                    case 7:
                        Saturdays++;
                        break;
                }
            }
        }
        bf.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter("friday.out"));
        bw.write(Saturdays + " " + Sundays + " " + Mondays + " " + Tuesdays + " " + Wednesdays + " " + Thursdays + " " + Fridays + "\n");
        bw.close();
    }

}
