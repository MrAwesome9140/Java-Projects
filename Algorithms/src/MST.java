import java.util.*;

public class MST {

    int[] parent;
    double[] key;

    void prims(Graph g, int start){
        parent = new int[g.graph.size()];
        key = new double[g.graph.size()];
        key[start] = 0;
        PriorityQueue<Integer> verts = new PriorityQueue<>((o1, o2) -> (int)(key[o2]*1000-key[o1]*1000));
        verts.addAll(g.allVerts);
        while(!verts.isEmpty()){
            int curVert = verts.poll();
            ArrayList<Edge> adjs = g.graph.get(curVert);
            adjs.forEach(edge -> {
                int vert;
                if((((vert=edge.vert1)!=curVert && verts.contains(edge.vert1)) || ((vert=edge.vert2)!=curVert && verts.contains(edge.vert2))) && edge.weight<key[curVert]){
                    parent[vert] = curVert;
                    key[vert] = edge.weight;
                }
            });
        }
    }

}

class Graph{

    HashMap<Integer, ArrayList<Edge>> graph = new HashMap<>();
    ArrayList<Integer> allVerts = new ArrayList<>();

}

class Edge{

    Integer vert1;
    Integer vert2;
    double weight;

    public Edge(Integer vert1, Integer vert2, double weight){
        this.vert1 = vert1;
        this.vert2 = vert2;
        this.weight = weight;
    }

}
