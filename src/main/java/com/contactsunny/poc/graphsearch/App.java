package com.contactsunny.poc.graphsearch;

public class App {

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("Starting Depth First Search (DFS) from vertex 2");
        graph.performDFS(2);

        System.out.println();
        System.out.println("Starting Breadth First Search (BFS) from vertex 2");
        graph.performBFS(2);
    }
}
