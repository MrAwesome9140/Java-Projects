import java.util.*;

public class Solution14 {

    static int[][] enjoyPath;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        enjoyPath = new int[n+1][n+1];
        for(int i = 0; i<enjoyPath.length; i++)
            Arrays.fill(enjoyPath[i], Integer.MIN_VALUE);
        Graph g = new Graph();
        g.vertices.add(new Vertex(0,0));
        for(int i = 0; i<n; i++){
            int temp = sc.nextInt();
            Vertex v = new Vertex(i+1, temp);
            g.vertices.add(v);
            g.edges.put(v, new ArrayList<>());
        }
        sc.nextLine();
        for(int i = 0; i<n-1; i++){
            String[] temp = sc.nextLine().split(" ");
            Vertex first = g.vertices.get(Integer.parseInt(temp[0]));
            Vertex sec = g.vertices.get(Integer.parseInt(temp[1]));
            g.edges.get(first).add(sec);
            g.edges.get(sec).add(first);
        }
        solve(g);
    }

    static void solve(Graph g){
        for(int i = 1; i<g.vertices.size(); i++){
//            Vertex[] parent = new Vertex[i+1];
            boolean[] searched = new boolean[g.vertices.size()+1];
            Vertex t = g.vertices.get(i);
            enjoyPath[t.index][t.index] = t.enjoy;
            Queue<Vertex> adjs = new LinkedList<>();
            adjs.add(t);
            searched[t.index] = true;
            int maxEnjoy = Integer.MIN_VALUE;
            while(!adjs.isEmpty()){
                Vertex temp = adjs.poll();
                ArrayList<Vertex> next = g.edges.get(temp);
                for(Vertex v:next){
                    if(!searched[v.index]) {
                        searched[v.index] = true;
                        if (enjoyPath[t.index][v.index] == Integer.MIN_VALUE) {
//                        parent[v.index] = temp;
                            enjoyPath[t.index][v.index] = enjoyPath[t.index][temp.index] + v.enjoy;
                            enjoyPath[v.index][t.index] = enjoyPath[t.index][temp.index] + v.enjoy;
                        }
                        adjs.add(v);
                        maxEnjoy = Math.max(maxEnjoy, enjoyPath[t.index][v.index]);
                    }
                }
            }
            System.out.println(maxEnjoy);
//            for(int k = 1; k<g.vertices.size(); k++){
//                Vertex temp = g.vertices.get(k);
//                if(!temp.equals(t) && enjoyPath[i][k]==Integer.MIN_VALUE){
//
//                }
//            }
        }
    }

    static class Graph{

        HashMap<Vertex, ArrayList<Vertex>> edges = new HashMap<>();
        ArrayList<Vertex> vertices = new ArrayList<>();

    }

    static class Vertex{

        int index;
        int enjoy;

        public Vertex(int index, int enjoy){
            this.index = index;
            this.enjoy = enjoy;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Vertex)) return false;
            Vertex vertex = (Vertex) o;
            return index == vertex.index &&
                    enjoy == vertex.enjoy;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, enjoy);
        }
    }

}
