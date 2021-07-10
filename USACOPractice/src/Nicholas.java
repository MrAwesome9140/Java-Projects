import java.io.*;

public class Nicholas {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("Nicholas.dat")));

        String s = "";

        while((s = br.readLine()) != null){
            String[] temp = s.split("\\s++");
            int N = Integer.parseInt(temp[0]);
            int P = Integer.parseInt(temp[1]);
            int[][] graph = new int[N][N];
            for(int i = 0; i<N; i++){
                String wow = temp[2+i];
                for(int k = 0; k<wow.length(); k++){
                    graph[i][k] = Integer.parseInt(String.valueOf(wow.charAt(k)));
                }
            }
            System.out.println(multiplyMatrix(graph,graph.clone(), P));
        }

    }

    static int multiplyMatrix(int[][] graph, int[][] otherGraph, int P){
        P--;
        if(P==0)
            return sumOfAll(graph);
        int[][] news = new int[graph.length][graph.length];
        for(int i = 0; i<graph.length; i++){
            for(int k = 0; k<graph.length; k++){
                news[i][k] = 0;
                for(int j = 0; j<graph.length; j++){
                    news[i][k]+=graph[i][j]*otherGraph[j][k];
                }
            }
        }
        if(P==1)
            return sumOfAll(news);
        else
            return multiplyMatrix(graph, news, P);
    }

    static int sumOfAll(int[][] graph){
        int sum = 0;
        for(int i = 0; i<graph.length; i++){
            for(int k = 0; k<graph.length; k++){
                sum+=graph[i][k];
            }
        }
        return sum;
    }

}
