import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class leftout {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("leftout.in")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("leftout.out")));
        int N = Integer.parseInt(br.readLine());
        int[][] grid = new int[N][N];
        for(int i = 0; i<N; i++){
            String temp = br.readLine();
            for(int k = 0; k<N; k++){
                grid[i][k] = temp.charAt(k)=='L' ? 1:0;
            }
        }
        br.close();
        PriorityQueue<int[]> points = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]!=o2[0]?o1[0]-o2[0]:o1[1]-o2[1];
            }
        });
        for(int row = 0; row<N-1; row++){
            for(int col = 0; col<N-1; col++){
                int numL = 0;
                int numR = 0;
                if(grid[row][col]==0)
                    numR++;
                else
                    numL++;
                if(grid[row+1][col]==0)
                    numR++;
                else
                    numL++;
                if(grid[row][col+1]==0)
                    numR++;
                else
                    numL++;
                if(grid[row+1][col+1]==0)
                    numR++;
                else
                    numL++;

                if(numL==1 || numR==1)
                    points.add(new int[]{row,col});
            }
        }
        if(points.size()==0)
            bw.write("-1");
        else{
            int[] temp = points.poll();
            bw.write(String.valueOf((temp[0]+1)+" "+(temp[1]+1)));
        }
        bw.close();

    }

}
