//package com.company;
//
//import java.util.*;
//import java.util.*;
//
//public class Djikstra {
//
//    public static Graph shortestPathFromSource(Graph graph, Node source){
//        source.setDistance(0);
//        HashSet<Node> unsettledNodes = new HashSet<>();
//        HashSet<Node> settledNode = new HashSet<>();
//
//        unsettledNodes.add(source);
//
//        while(unsettledNodes.size()!=0){
//            Node currentNode = getLowestDistanceNode(unsettledNodes);
//            unsettledNodes.remove(currentNode);
//            for(Map.Entry<Node, Integer> adjacencyPair: currentNode.getAdjacentNodes().entrySet()){
//                Node adjacentNode = adjacencyPair.getKey();
//                int edgeWeight = adjacencyPair.getValue();
//                if(!settledNode.contains(adjacentNode)){
//                        calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
//                        unsettledNodes.add(adjacentNode);
//                }
//            }
//            settledNode.add(currentNode);
//        }
//        return graph;
//    }
//
//    private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
//        Node lowestDistanceNode = null;
//        int lowestDistance = Integer.MAX_VALUE;
//        for (Node node: unsettledNodes) {
//            int nodeDistance = node.getDistance();
//            if (nodeDistance < lowestDistance) {
//                lowestDistance = nodeDistance;
//                lowestDistanceNode = node;
//            }
//        }
//        return lowestDistanceNode;
//    }
//
//    public static void calculateMinimumDistance(Node currentNode, int edgeWeight, Node sourceNode){
//        int sourceDistance = sourceNode.getDistance();
//        if (sourceDistance + edgeWeight < currentNode.getDistance()) {
//            currentNode.setDistance(sourceDistance + edgeWeight);
//            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPaths());
//            shortestPath.add(sourceNode);
//            currentNode.setShortestPath(shortestPath);
//        }
//    }
//
//}
