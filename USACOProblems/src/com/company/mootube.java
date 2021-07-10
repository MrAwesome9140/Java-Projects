//package com.company;
//
//import java.io.*;
//import java.util.*;
//
//public class mootube {
//
//    static HashSet<Node> settledNodes = new HashSet<>();
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new FileReader(new File("mootube.in")));
//        String[] ts = br.readLine().split(" ");
//        int N = Integer.parseInt(ts[0]);
//        int Q = Integer.parseInt(ts[1]);
//
//        Graph g = new Graph();
//
//        for(int i = 1; i<=N; i++){
//            g.addNode(new Node(i));
//        }
//
//        for(int i = 0; i<N-1; i++){
//            String[] t = br.readLine().split(" ");
//            g.addAdjacentNode(new Node(Integer.parseInt(t[0])), new Node(Integer.parseInt(t[1])), Integer.parseInt(t[2]));
//            g.addAdjacentNode(new Node(Integer.parseInt(t[1])), new Node(Integer.parseInt(t[0])), Integer.parseInt(t[2]));
//        }
//
//        String s = "";
//        while((s=br.readLine())!=null){
//            int nums = 0;
//            String[] temp = s.split(" ");
//            int K = Integer.parseInt(temp[0]);
//            int video = Integer.parseInt(temp[1]);
//            numRelevantVids(K, new Node(video), g, N);
//            for(Node n:g.nodes.keySet()){
//                if(n.shortestPath>=K)
//                    nums++;
//            }
//            System.out.println(nums);
//        }
//
//    }
//
//    public static void numRelevantVids(int K, Node main, Graph g, int N){
//        LinkedList<Node> nodes = new LinkedList<>();
//        nodes.offer(main);
//        boolean[] used = new boolean[N];
//        used[main.val] = true;
//        int res = 0;
//
//        while (nodes.size()>0){
//            Node current = nodes.poll();
//            res++;
//            for(Node n:g.nodes.get(current).keySet()){
//                if(!used[n.val] && n.shortestPath>K);
//            }
//        }
//
//    }
//
//}
//
//class Graph{
//
//    HashMap<Node, HashMap<Node, Integer>> nodes = new HashMap<>();
//
//    public Graph(){
//
//    }
//
//    public void addNode(Node n){
//        nodes.put(n, new HashMap<>());
//    }
//
//    public void addAdjacentNode(Node n1, Node n2, int dist){
//        if(!hasNode(n1))
//            addNode(n1);
//        nodes.get(n1).put(n2, dist);
//    }
//
//    public boolean hasAdjacentNode(Node n1, Node n2){
//        return nodes.get(n1).containsKey(n2);
//    }
//
//    public boolean hasNode(Node n1){
//        for(Node n:nodes.keySet()){
//            if(n.val==n1.val)
//                return true;
//        }
//        return false;
//    }
//
//}
//
//class Node{
//
//    int val;
//    int shortestPath;
//
//    public Node(int val){
//        this.val = val;
//    }
//
//    public void setShortestPath(int dist){
//        shortestPath = dist;
//    }
//
//    public int compareTo(Node node){
//        String s = "k";
//
//    }
//
//}
