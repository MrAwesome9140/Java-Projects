import java.time.Clock;
import java.time.Instant;
import java.time.LocalTime;
import java.util.*;
import java.io.*;

public class milkvisits {

    static int[] connections;

    public static void main(String[] args) throws IOException{

        long currentTime = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new FileReader(new File("milkvisits.in")));
        String[] wow = br.readLine().split(" ");

        int N = Integer.parseInt(wow[0]);
        int M = Integer.parseInt(wow[1]);

        connections = new int[N];

        Graphs g = new Graphs();

        char[] tempCows = br.readLine().toCharArray();
        Node[] myNodes = new Node[N];

        for(int i = 1; i<=N; i++){
            Node n = new Node(i, tempCows[i-1]);
            myNodes[i-1] = n;
            g.addNode(n);
        }

        for(int i = 0; i<N-1; i++){
            String[] t = br.readLine().split(" ");
            Node initial = myNodes[Integer.parseInt(t[0])-1];
            Node fin = myNodes[Integer.parseInt(t[1])-1];
            g.addEdge(initial, fin);
        }

        int[] startPoints = new int[M];
        int[] endPoints = new int[M];
        char[] preferences = new char[M];

        for(int i = 0;i<M; i++){
            String[] temp = br.readLine().split(" ");
            startPoints[i] = Integer.parseInt(temp[0]);
            endPoints[i] = Integer.parseInt(temp[1]);
            preferences[i] = temp[2].charAt(0);
        }

        int num = 0;
        for(int i = 0; i<connections.length; i++){
            if(connections[i]==0){
                num++;
                DFS(g, new Node(i+1, myNodes[i].cowType), num);
            }
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("milkvisits.out")));

        for(int i = 0; i<M; i++){
            Node init = new Node(startPoints[i], tempCows[startPoints[i]-1]);
            Node fin = new Node(endPoints[i], tempCows[endPoints[i]-1]);
            if(init.cowType == preferences[i] || connections[init.pos-1] != connections[fin.pos-1])
                bw.write("1");
            else
                bw.write("0");
        }


        bw.close();

        System.out.print(System.currentTimeMillis()-currentTime);

    }

    public static void DFS(Graphs g, Node node, int N){
        if(connections[node.pos-1]!=0)return;
        connections[node.pos-1] = N;
        for(Node n:g.nodeConnects.get(node)){
            if(n.cowType==node.cowType)
                DFS(g, n, N);
        }
    }

}

class Graphs{

    HashMap<Node, ArrayList<Node>> nodeConnects = new HashMap<>();

    public Graphs(){

    }

    public void addNode(Node node){
        nodeConnects.put(node, new ArrayList<>());
    }

    public void addEdge(Node initial, Node fin){
//        if(!nodeConnects.containsKey(initial))
//            addNode(initial);
//        if(!nodeConnects.containsKey(fin))
//            addNode(fin);

        nodeConnects.get(initial).add(fin);
        nodeConnects.get(fin).add(initial);
    }
}

class Node{

    int pos;
    char cowType;

    public Node(int pos, char cowType){
        this.pos = pos;
        this.cowType = cowType;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Node){
            return ((Node)obj).pos==this.pos && ((Node)obj).cowType==this.cowType;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return String.valueOf(pos).hashCode();
    }
}