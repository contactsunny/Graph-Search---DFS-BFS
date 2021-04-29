package com.contactsunny.poc.graphsearch;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    // This is the identifier of the vertex
    // This is also the data that we're going to store in the vertex
    // You can instead use a generic class to store a specific data field.
    private final int id;

    // This will hold the list of all adjacent vertices fot the current vertex
    private final List<Vertex> adjacentVertices = new ArrayList<Vertex>();

    // This will hold the list of all the edges from and to this vertex
    private final List<Edge> edges = new ArrayList<Edge>();

    public Vertex(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    /**
     * Adding an edge to this vertex
     * @param edge The edge to be added.
     */
    public void addEdge(Edge edge) {
        this.edges.add(edge);
        // Checking if the first vertex is the vertex we're working with.
        // If so, we'll add the second vertex as the adjacent vertex.
        if (edge.getV1().id == this.id) {
            this.adjacentVertices.add(edge.getV2());
        } else {
            // If the IDs don't match in the if condition,
            // We'll add the first vertex as the adjacent vertex to this vertex
            this.adjacentVertices.add(edge.getV1());
        }
    }

    public List<Vertex> getAdjacentVertices() {
        return adjacentVertices;
    }
}
