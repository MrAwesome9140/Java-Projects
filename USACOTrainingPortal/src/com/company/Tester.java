//package com.company;
//
//public class Tester {
//
//    public static void main(String[] args){
//        Graph g = new Graph();
//
//        Node a = new Node("a");
//        Node b = new Node("b");
//        Node c = new Node("c");
//        Node d = new Node("d");
//        Node e = new Node("e");
//        Node f = new Node("f");
//
//        a.addDestination(b, 10);
//        a.addDestination(c, 15);
//
//        b.addDestination(d, 12);
//        b.addDestination(f, 15);
//
//        c.addDestination(e, 10);
//
//        d.addDestination(f, 1);
//        d.addDestination(e, 2);
//
//        f.addDestination(e, 5);
//
//        g.addNode(a);
//        g.addNode(b);
//        g.addNode(c);
//        g.addNode(d);
//        g.addNode(e);
//        g.addNode(f);
//
//        g = Djikstra.shortestPathFromSource(g, a);
//
//        for(Node p:g.getNodes()){
//            System.out.println(p.getName() + " " + p.getDistance());
//        }
//    }
//
//}
