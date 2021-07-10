//package com.company;
//
//import java.util.*;
//
//public class Node {
//
//    private String name;
//
//    private List<Node> shortestPaths = new LinkedList<>();
//
//    private int distance = Integer.MAX_VALUE;
//
//    HashMap<Node, Integer> adjacentNodes = new HashMap<Node, Integer>();
//
//    public void addDestination(Node n, int distance){
//        adjacentNodes.put(n,distance);
//    }
//
//    public Node(String name){
//        this.name = name;
//    }
//
//    public String getName(){
//        return name;
//    }
//
//    public int getDistance(){
//        return distance;
//    }
//
//    public void setDistance(int distance){
//        this.distance = distance;
//    }
//
//    public void addToPath(Node node){
//        shortestPaths.add(node);
//    }
//
//    public List<Node> getShortestPaths(){ return shortestPaths; }
//
//    public void setShortestPath(LinkedList<Node> temp){
//        shortestPaths = temp;
//    }
//
//    public HashMap<Node, Integer> getAdjacentNodes(){
//        return adjacentNodes;
//    }
//
//}
