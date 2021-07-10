import java.awt.*;
import java.io.*;
import java.util.*;

public class Problem1 {

    static ArrayList<Point> added = new ArrayList<>();
    static int prevAdded = 0;

    public static void main(String[] args) throws IOException {

        int[][] coords = {{0,0},{1,0},{-1,0},{0,1},{0,-1}};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Point[] points = new Point[n];
        boolean[][] grid = new boolean[3000][3000];
        int[][] adjs = new int[3000][3000];
        for(int i = 0; i<adjs.length; i++)
            Arrays.fill(adjs[i], -1);
        for(int i = 0; i<n; i++){
            String[] temp = br.readLine().split(" ");
            int x = Integer.parseInt(temp[0])+1000;
            int y = Integer.parseInt(temp[1])+1000;
            points[i] = new Point(x,y);
        }
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i<points.length; i++){
            Point poi = points[i];
            if(grid[poi.x][poi.y])
                prevAdded--;
            else {
                grid[poi.x][poi.y] = true;
                for (int k = 0; k < coords.length; k++) {
                    Point temp = new Point(poi.x + coords[k][0], poi.y + coords[k][1]);
                    boolean same = k==0;
                    if (grid[temp.x][temp.y])
                        checkPoint(coords, temp, grid, adjs, same);
                }
            }
            answer.append(prevAdded+"\n");
        }
        System.out.print(answer);
    }

    static void checkPoint(int[][] coords, Point p, boolean[][] grid, int[][] adjs, boolean same){
        if(adjs[p.x][p.y] == -1) {
            int adj = 0;
            Point leftover = new Point(0, 0);
            if (grid[p.x + 1][p.y])
                adj++;
            else
                leftover = new Point(p.x + 1, p.y);
            if (grid[p.x - 1][p.y])
                adj++;
            else
                leftover = new Point(p.x - 1, p.y);
            if (grid[p.x][p.y + 1])
                adj++;
            else
                leftover = new Point(p.x, p.y + 1);
            if (grid[p.x][p.y - 1])
                adj++;
            else
                leftover = new Point(p.x, p.y - 1);

            if (adj == 3) {
                added.add(leftover);
                grid[leftover.x][leftover.y] = true;
                prevAdded++;
                adjs[p.x][p.y] = 4;
                for (int i = 0; i < coords.length; i++) {
                    Point temp = new Point(leftover.x + coords[i][0], leftover.y + coords[i][1]);
                    boolean s = i==0;
                    if (grid[temp.x][temp.y] && temp.x!=p.x && temp.y!=p.y)
                        checkPoint(coords, temp, grid, adjs, s);
                }
            } else {
                adjs[p.x][p.y] = adj;
            }
        }
        else{
            if(!same)
                adjs[p.x][p.y]++;
            if(adjs[p.x][p.y]==3){
                Point leftover;
                if (!grid[p.x + 1][p.y])
                    leftover = new Point(p.x + 1, p.y);
                else if (!grid[p.x - 1][p.y])
                    leftover = new Point(p.x - 1, p.y);
                else if (!grid[p.x][p.y + 1])
                    leftover = new Point(p.x, p.y + 1);
                else
                    leftover = new Point(p.x, p.y - 1);

                added.add(leftover);
                grid[leftover.x][leftover.y] = true;
                prevAdded++;
                adjs[p.x][p.y] = 4;
                for (int i = 0; i < coords.length; i++) {
                    Point temp = new Point(leftover.x + coords[i][0], leftover.y + coords[i][1]);
                    boolean s = i==0;
                    if (grid[temp.x][temp.y] && temp.x!=p.x && temp.y!=p.y)
                        checkPoint(coords, temp, grid, adjs, s);
                }
            }
        }
    }

}
