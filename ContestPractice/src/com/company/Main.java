package com.company;

import javax.swing.text.html.HTMLDocument;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Main {

    enum Color{
        RED(1),
        GREEN(2),
        BLUE(3);
        int popularity;

        Color(int popularity){
            this.popularity=popularity;
        }
    }

    public static void main(String[] args) {
        for(Color c:Color.values()){
            System.out.println("This color is " + c + " and its popularity is " + c.popularity);
        }
    }

}
