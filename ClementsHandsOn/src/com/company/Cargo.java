package com.company;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Cargo {

    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(new File("cargo.dat"));
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            String[] temp = s.split("-");
            String[] tem = s.split("/");
            String[] vals = {temp[0], tem[0], tem[1]};
        }

    }
}
