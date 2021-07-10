import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class prob21 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char[][] grid;
        String s = sc.nextLine();
        ArrayList<String> strings = new ArrayList<>();
        strings.add(s);
        while(sc.hasNextLine()){
            strings.add(sc.nextLine());
        }

        grid = new char[strings.size()][s.length()];
        for(int i = 0; i<strings.size(); i++){
            for(int k = 0; k<strings.get(i).length(); k++){
                grid[i][k] = strings.get(i).charAt(k);
            }
        }

        for(int i = 0; i<grid.length; i++){
            boolean leave = false;
            for(int k = 0; k<grid[i].length; k++){
                Point[] ans;
                if((ans=findMojo(grid, new Point(i,k))).length!=0){
                    System.out.println("M: "+ans[0].y+","+ans[0].x);
                    System.out.println("O: "+ans[1].y+","+ans[1].x);
                    System.out.println("J: "+ans[2].y+","+ans[2].x);
                    System.out.println("O: "+ans[3].y+","+ans[3].x);
                    leave = true;
                    break;
                }
            }
            if(leave)
                break;
        }

    }

    static Point[] findMojo(char[][] grid, Point cur){
        StringBuffer leftHoz = new StringBuffer();
        StringBuffer rightHoz = new StringBuffer();
        StringBuffer topVert = new StringBuffer();
        StringBuffer botVert = new StringBuffer();
        StringBuffer square = new StringBuffer();
        for(int i = 3; i>=0; i--){
            if(cur.y-i>=0)
                leftHoz.append(grid[cur.x][cur.y-i]);
            if(cur.y+i<grid[0].length)
                rightHoz.append(grid[cur.x][cur.y+i]);
            if(cur.x-i>=0)
                topVert.append(grid[cur.x-i][cur.y]);
            if(cur.x+i<grid.length)
                botVert.append(grid[cur.x+i][cur.y]);
        }
        square.append(grid[cur.x][cur.y]);
        if(cur.x+1<grid.length && cur.y+1<grid[0].length){
            square.append(grid[cur.x][cur.y+1]);
            square.append(grid[cur.x+1][cur.y]);
            square.append(grid[cur.x+1][cur.y+1]);
        }

        if(leftHoz.toString().equals("MOJO")){
            Point[] p = new Point[4];
            for(int i = 3; i>=0; i--)
                p[3-i] = new Point(cur.x, cur.y-i);
            return p;
        }
        else if(rightHoz.toString().equals("MOJO")){
            Point[] p = new Point[4];
            for(int i = 3; i>=0; i--)
                p[3-i] = new Point(cur.x, cur.y+i);
            return p;
        }
        else if(topVert.toString().equals("MOJO")){
            Point[] p = new Point[4];
            for(int i = 3; i>=0; i--)
                p[3-i] = new Point(cur.x-i, cur.y);
            return p;
        }
        else if(botVert.toString().equals("MOJO")){
            Point[] p = new Point[4];
            for(int i = 3; i>=0; i--)
                p[3-i] = new Point(cur.x+i, cur.y);
            return p;
        }
        else if(square.toString().equals("MOJO")){
            Point[] p = new Point[4];
            p[0] = new Point(cur.x, cur.y);
            p[1] = new Point(cur.x, cur.y+1);
            p[2] = new Point(cur.x+1, cur.y);
            p[3] = new Point(cur.x+1, cur.y+1);
            return p;
        }
        else
            return new Point[0];
    }

}
