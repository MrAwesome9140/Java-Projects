import java.util.*;
import java.io.*;

public class planting {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new FileReader(new File("planting.in")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("planting.out")));

        int N = Integer.parseInt(br.readLine());
        ArrayList[] connects = new ArrayList[N];

        for(int i = 0; i<connects.length; i++) connects[i] = new ArrayList<Edge>();

        for(int i = 0; i<N-1; i++){
            String[] t = br.readLine().split(" ");
            int node1 = Integer.parseInt(t[0])-1;
            int node2 = Integer.parseInt(t[1])-1;
            connects[node1].add(new Edge(node2));
            connects[node2].add(new Edge(node1));
        }

        int greatest = 0;
        for(ArrayList<Edge> edges: connects){
            greatest = Math.max(edges.size(), greatest);
        }

        bw.write(String.valueOf(greatest+1));
        bw.close();
    }

}

class Edge{

    int node;

    public Edge(int node){
        this.node = node;
    }

}
