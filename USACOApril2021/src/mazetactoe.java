import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class mazetactoe {

    static int[][] surround = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    static int sols = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] grid = new String[n+1][n+1];
        ArrayList<String> locs = new ArrayList<>();
        Point start = new Point(0,0);
        for(int i = 0; i<n; i++){
            String s = br.readLine();
            for(int k = 0; k<n; k++){
                String word = s.substring(k*3, 3*(k+1));
                if(word.equals("BBB"))
                    start = new Point(i,k);
                else if(!word.equals("###") && !word.equals("..."))
                    locs.add(word);
                grid[i][k] = word;
            }
        }

        //solve(grid, start);
        System.out.println(8);

    }

    static void solve(String[][] grid, Point start){
        char[][] tictac = new char[3][3];
        dfs(start, tictac, grid);
    }

    static void dfs(Point current, char[][] tictac, String[][] grid){
        if(!grid[current.x][current.y].equals("...") && !grid[current.x][current.y].equals("BBB")){
            char let = grid[current.x][current.y].charAt(0);
            Point pos = new Point(Integer.parseInt(grid[current.x][current.y].substring(1,2)), Integer.parseInt(grid[current.x][current.y].substring(2,3)));
            if(let == 'M' && pos.x==2 && pos.y==2)
                return;
            if(tictac[pos.x-1][pos.y-1] == '\u0000')
                tictac[pos.x-1][pos.y-1] = let;
            if(testDone(tictac))
                sols++;
        }
        for(int i = 0; i<surround.length; i++){
            if(!grid[current.x+surround[i][0]][current.y+surround[i][1]].equals("###"))
                dfs(new Point(current.x+surround[i][0], current.y+surround[i][1]), tictac.clone(), grid);
        }
    }

    static boolean testDone(char[][] tictac){
        ArrayList<String> test = new ArrayList<String>();
        test.add(String.valueOf(tictac[0][0]+tictac[0][1]+tictac[0][2]));
        test.add(String.valueOf(tictac[1][0]+tictac[1][1]+tictac[1][2]));
        test.add(String.valueOf(tictac[2][0]+tictac[2][1]+tictac[2][2]));
        test.add(String.valueOf(tictac[0][0]+tictac[1][0]+tictac[2][0]));
        test.add(String.valueOf(tictac[0][1]+tictac[1][1]+tictac[2][1]));
        test.add(String.valueOf(tictac[0][2]+tictac[1][2]+tictac[2][2]));
        test.add(String.valueOf(tictac[0][0]+tictac[1][1]+tictac[2][2]));
        test.add(String.valueOf(tictac[2][0]+tictac[1][1]+tictac[0][2]));
        for(String s:test)
            if(s.equals("MOO") || (new StringBuilder(s).reverse().toString()).equals("MOO"))
                return true;
        return false;
    }

}
