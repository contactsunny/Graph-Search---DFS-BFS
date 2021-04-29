package com.contactsunny.poc.graphsearch;

import java.util.*;

public class Graph {

    // A map to hold all vertices based on the value or the ID of the vertex
    private final Map<Integer, Vertex> vertexMap = new HashMap<Integer, Vertex>();
    // A set to hold the list of all the visited vertices during a search
    private Set<Integer> visited = new HashSet<Integer>();

    /**
     * Adding an edge between two vertices
     *
     * @param value1 value of the first vertex of the edge
     * @param value2 value of the second vertex of the edge
     */
    public void addEdge(int value1, int value2) {
        Vertex v1 = getVertex(value1);
        Vertex v2 = getVertex(value2);
        // Creating an edge between both the vertices
        Edge edge = new Edge(v1, v2);
        // Adding the edge to the vertex
        v1.addEdge(edge);
        System.out.println("Adding edge: " + value1 + " -> " + value2);
    }

    /**
     * Getting a vertex from the graph
     *
     * @param value The value or the ID of the vertex
     * @return The vertex
     */
    private Vertex getVertex(int value) {
        // Checking if the map already contains the required vertex.
        // If found, returning it.
        if (vertexMap.containsKey(value)) {
            return vertexMap.get(value);
        }

        // If we don't find the vertex, we'll create one.
        Vertex vertex = new Vertex(value);
        // Adding the new vertex to the map.
        vertexMap.put(value, vertex);
        // Returning the new vertex
        return vertex;
    }

    /**
     * Performing depth first search on the map, starting from the given vertex ID
     *
     * @param value the ID of the vertex from where the search has to start.
     */
    public void performDFS(int value) {
        // Making sure the vertex is present.
        if (vertexMap.containsKey(value)) {
            // Getting the vertex from the map.
            Vertex vertex = vertexMap.get(value);
            // Checking if we have already visited this vertex. If so, skip.
            if (!visited.contains(vertex.getId())) {
                // Adding this vertex to the visited vertex set.
                visited.add(vertex.getId());
                // Printing the ID of the vertex
                System.out.print(vertex.getId() + " ");

                // Performing DFS on all the adjacent vertices of the vertex.
                for (Vertex adjacentVertex : vertex.getAdjacentVertices()) {
                    performDFS(adjacentVertex.getId());
                }
            }
        }
    }

    /**
     * Performing breadth first search on the map, starting from the given vertex ID
     *
     * @param value the ID of the vertex from where the search has to start.
     */
    public void performBFS(int value) {
        // Creating a queue for storing adjacent vertices.
        Queue<Vertex> queue = new LinkedList<Vertex>();

        // Checking if the map contains the vertex.
        if (vertexMap.containsKey(value)) {
            // Getting the vertex from where the search will begin.
            Vertex startingVertex = vertexMap.get(value);
            // Adding the vertex to the queue.
            queue.add(startingVertex);
            // Looping over the queue unless it becomes empty.
            while (!queue.isEmpty()) {
                // Getting the first vertex from the queue.
                Vertex vertex = queue.poll();
                // Checking if we've already visited the vertex. Skipping if yes.
                if (!visited.contains(vertex.getId())) {
                    // Adding the vertex to the visited set.
                    visited.add(vertex.getId());
                    // Printing the ID of the vertex.
                    System.out.print(vertex.getId() + " ");
                    // Looping over all the adjacent vertices of the current vertex
                    for (Vertex adjacentVertex : vertex.getAdjacentVertices()) {
                        // Adding all adjacent vertices to the queue, which will be polled later.
                        queue.add(adjacentVertex);
                    }
                }
            }
        }
    }

    /**
     * Method to clear the visited set so that if you run DFS or BFS back-to-back, it won't fail.
     */
    public void clearVisitedSet() {
        // Clearing the visited set as it is already populated by DFS.
        visited = new HashSet<Integer>();
    }
}
