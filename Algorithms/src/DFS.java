import java.awt.*;
import java.io.*;
import java.util.*;

public class DFS {

    static Point end;

    public static void main(String[] args) throws IOException, InterruptedException {

        BufferedReader br = new BufferedReader(new FileReader(new File("test.dat")));
        int[][] maze = new int[10][10];
        int[][] estDists = new int[10][10];
        ArrayList<Point> doors = new ArrayList<>();
        for(int k = 0; k<10; k++){
            char[] temp = br.readLine().toCharArray();
            for(int j = 0; j<10; j++){
                if(temp[j]=='#')
                    maze[k][j] = 0;
                else if(temp[j]=='.'){
                    if(k==0 || k==9 || j==0 || j==9)
                        doors.add(new Point(k, j));
                    maze[k][j] = 1;
                }
                else{
                    if(k==0 || k==9 || j==0 || j==9)
                        doors.add(new Point(k, j));
                    maze[k][j] = 2;
                    end = new Point(k, j);
                }
            }
        }

        for(int k = 0; k<maze.length; k++){
            for(int j = 0; j<maze.length; j++){
                if(maze[k][j]!=0){
                    estDists[k][j] = Math.abs(k-end.x)+Math.abs(j-end.y);
                }
            }
        }

        String[][] visualMaze = new String[10][10];
        for(int i = 0; i<maze.length; i++){
            for(int j = 0; j<maze.length; j++){
                visualMaze[i][j] = maze[i][j] == 0 ? "#" : "+";
            }
        }

        for(Point p:doors){
            DFS(maze, p, visualMaze.clone(), estDists);
            System.out.println("--------------------"+"\n");
        }

    }

    static void DFS(int[][] maze, Point start, String[][] visMaze, int[][] estDists) throws InterruptedException {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Point[][] parent = new Point[maze.length][maze[0].length];

        DFSVisit(maze, start, visited, parent, visMaze, start, estDists);

    }

    static void DFSVisit(int[][] maze, Point curVert, boolean[][] visited, Point[][] parent, String[][] visMaze, Point start, int[][] estDists) throws InterruptedException {
        Thread.sleep(500);
        visMaze[curVert.x][curVert.y] = "%";
        if(curVert.equals(end)){
            path(visMaze, parent);
            visMaze[start.x][start.y] = "X";
            visMaze[end.x][end.y] = "o";
            printArray(visMaze);
            System.out.println();
        }
        visMaze[start.x][start.y] = "X";
        visMaze[end.x][end.y] = "o";
        printArray(visMaze);
        System.out.println();
        visited[curVert.x][curVert.y] = true;
        ArrayList<Point> adjacentVerts = adjacent(maze, curVert);
        Collections.sort(adjacentVerts, Comparator.comparingInt(a -> estDists[a.x][a.y]));
        if(adjacentVerts.isEmpty())
            return;
        for(Point p : adjacentVerts){
            if(visited[end.x][end.y])
                return;
            if(!visited[p.x][p.y]){
                parent[p.x][p.y] = curVert;
                DFSVisit(maze, p, visited.clone(), parent.clone(), cloneArray(visMaze), start, estDists);
            }
        }
    }

    static String[][] cloneArray(String[][] temp){
        String[][] copy = new String[10][10];
        for(int i = 0; i<10; i++){
            for(int j = 0; j<10; j++){
                copy[i][j] = new String(temp[i][j]);
            }
        }
        return copy;
    }

    static ArrayList<Point> adjacent(int[][] maze, Point p){
        int[][] possible = {{1,0},{-1,0},{0,1},{0,-1}};
        ArrayList<Point> adjs = new ArrayList<>();
        for(int[] i:possible){
            if(inBounds(p.x+i[0], p.y+i[1]) && maze[p.x+i[0]][p.y+i[1]]!=0)
                adjs.add(new Point(p.x+i[0], p.y+i[1]));
        }
        return adjs;
    }

    static boolean inBounds(int x, int y){
        return x>=0 && x<10 && y>=0 && y<10;
    }

    static void path(String[][] maze, Point[][] cameFrom){
        Stack<Point> s = new Stack<>();
        Point temp = cameFrom[end.x][end.y];
        while(temp != null){
            maze[temp.x][temp.y] = "^";
            temp = cameFrom[temp.x][temp.y];
        }
    }

    static void printArray(String[][] temp){
        for(String[] s: temp){
            for(String p:s){
                switch (p){
                    case "#":{
                        System.out.print(ConsoleColors.RED+p+ConsoleColors.RESET+" ");
                        break;
                    }
                    case "+":{
                        System.out.print(ConsoleColors.WHITE+p+ConsoleColors.RESET+" ");
                        break;
                    }
                    case "%":{
                        System.out.print(ConsoleColors.GREEN+p+ConsoleColors.RESET+" ");
                        break;
                    }
                    case "X":{
                        System.out.print(ConsoleColors.BLUE+p+ConsoleColors.RESET+" ");
                        break;
                    }
                    case "^":{
                        System.out.print(ConsoleColors.PURPLE_BOLD+p+ConsoleColors.RESET+" ");
                        break;
                    }
                    default:{
                        System.out.print(ConsoleColors.BLACK_BOLD+p+ConsoleColors.RESET+" ");
                        break;
                    }
                }
            }
            System.out.println();
        }
    }

}



class ConsoleColors {
    // Reset
    public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE

    // Bold
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

    // Underline
    public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
    public static final String RED_UNDERLINED = "\033[4;31m";    // RED
    public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
    public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
    public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
    public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
    public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
    public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

    // Background
    public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
    public static final String RED_BACKGROUND = "\033[41m";    // RED
    public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
    public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
    public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
    public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE

    // High Intensity
    public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
    public static final String RED_BRIGHT = "\033[0;91m";    // RED
    public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
    public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
    public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
    public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE

    // Bold High Intensity
    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

    // High Intensity backgrounds
    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
    public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
    public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE
}