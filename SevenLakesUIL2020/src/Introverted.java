import java.awt.*;
import java.util.*;

public class Introverted {

    static int[][] map;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] temp = sc.nextLine().split(" ");
        int h = Integer.parseInt(temp[0]);
        int w = Integer.parseInt(temp[1]);
        map = new int[h+2][w+2];
        ArrayList<int[]> aliens = new ArrayList<>();
        int startX = 0;
        int startY = 0;
        int goalX = 0;
        int goalY = 0;
        for(int i = 1; i<=h; i++){
            String[] line = sc.nextLine().split("");
            for(int k = 1; k<=w; k++){
                if(line[k].equals(" "))
                    map[i][k] = 1;
                else if(line[k].equals("D")) {
                    goalX = i;
                    goalY = k;
                    map[i][k] = 1;
                }
                else if(line[k].equals("P"))
                    aliens.add(new int[]{i, k});
                else if(line[k].equals("J")){
                    startX = i;
                    startY = k;
                }
            }
        }
        for(int[] hi: aliens){
            int x = hi[0];
            int y = hi[1];
            map[x+1][y] = 0;
            map[x-1][y] = 0;
            map[x][y+1] = 0;
            map[x][y-1] = 0;
            map[x+1][y+1] = 0;
            map[x+1][y-1] = 0;
            map[x-1][y+1] = 0;
            map[x-1][y-1] = 0;
        }

        int ans = solve(startX, startY, h, w, goalX, goalY);
        System.out.println(ans + " steps to escape!");

    }

    static int solve(int startX, int startY, int h, int w, int goalX, int goalY){
        boolean[][] searched = new boolean[h+1][w+1];
        Queue<Point> queue = new LinkedList<>();
        int[][] minDist = new int[h+1][w+1];
        queue.add(new Point(startX, startY));
        while(!queue.isEmpty()){
            Point cur = queue.poll();
            ArrayList<Point> available = getAdj(cur.x, cur.y);
            for(Point point: available) {
                if (!searched[point.x][point.y]) {
                    if(point.x == goalX && point.y == goalY)
                        return minDist[cur.x][cur.y] + 1;
                    searched[point.x][point.y] = true;
                    minDist[point.x][point.y] = minDist[cur.x][cur.y] + 1;
                    queue.add(point);
                }
            }
        }
        return minDist[goalX][goalY];
    }

    static ArrayList<Point> getAdj(int x, int y){
        ArrayList<Point> adj = new ArrayList<>();
        if(map[x+1][y]!=0)
            adj.add(new Point(x+1, y));
        if(map[x-1][y]!=0)
            adj.add(new Point(x-1, y));
        if(map[x][y+1]!=0)
            adj.add(new Point(x, y+1));
        if(map[x][y-1]!=0)
            adj.add(new Point(x, y-1));
        if(map[x+1][y+1]!=0)
            adj.add(new Point(x+1, y+1));
        if(map[x+1][y-1]!=0)
            adj.add(new Point(x+1, y-1));
        if(map[x-1][y+1]!=0)
            adj.add(new Point(x-1, y+1));
        if(map[x-1][y-1]!=0)
            adj.add(new Point(x-1, y-1));
        return adj;
    }

}
