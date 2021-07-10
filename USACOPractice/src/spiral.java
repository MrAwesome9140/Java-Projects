import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class spiral {

    static HashMap<String, int[]> moves = new HashMap<>();
    static String[] mOrder = {"NE", "E", "SE", "S", "SW", "W", "NW", "N"};
    static int[][] allAround = {{1,0}, {-1,0},{0,1},{0,-1}};
    static int[][] spiral;
    static int size;

    public static void main(String[] args) throws IOException {

        moves.put("NE", new int[]{1,1});
        moves.put("E", new int[]{1,0});
        moves.put("SE", new int[]{1, -1});
        moves.put("S", new int[]{0,-1});
        moves.put("SW", new int[]{-1,-1});
        moves.put("W", new int[]{-1,0});
        moves.put("NW", new int[]{-1, 1});
        moves.put("N", new int[]{0, 1});

        BufferedReader br = new BufferedReader(new FileReader(new File("spiral.dat")));
        size = Integer.parseInt(br.readLine());
        spiral = new int[size+2][size+2];

        int curX = size/2+1;
        int curY = size/2+1;

        spiral[curX][curY] = 1;
        int current = 0;
        curX+=moves.get(mOrder[current])[0];
        curY+=moves.get(mOrder[current])[1];
        spiral[curX][curY] = 1;
        while(current<mOrder.length){
            int temp1 = current==mOrder.length-1 ? 0:current+1;
            int tempX = 2;

            int temp2 = current==mOrder.length-1 ? 1: current==mOrder.length-2 ? 0:current+2;

        }


    }

    static boolean works(int x, int y){
        return x>=0 && x<size && y>=0 && y<size;
    }

    static boolean noAdjacents(int x, int y){
        for(int[] temp: allAround){
            if(works(x+temp[0], y+temp[1]) && spiral[x+temp[0]][y+temp[1]]==1)
                return false;
        }
        return true;
    }

}
