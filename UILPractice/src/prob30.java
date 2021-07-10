import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class prob30 {

    static int[][] graph;
    static int white;
    static int chocolate;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        int N = Integer.parseInt(br.readLine());

        graph = new int[N][N];

    }

    static boolean nonUniformBorder(){
        int i = graph[0][0];
        for(int k = 0; k<graph.length-1; k++){
            if(graph[k][0]!=i || graph[graph.length-1][k]!=i || graph[graph.length-1-k][graph.length-1]!=i || graph[0][graph.length-1-k]!=i)
                return true;
        }
        return false;
    }

    static boolean noUniform2x2(){
        for(int i = 0; i<graph.length-1; i++){
            for(int k = 0; k<graph.length-1; k++){
                int temp = graph[i][k];
                if(graph[i+1][k]==temp && graph[i+1][k+1]==temp && graph[i][k+1]==temp)
                    return false;
            }
        }
        return true;
    }

    static boolean twoRegions(){

    }

}
