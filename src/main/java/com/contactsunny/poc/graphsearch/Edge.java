package com.contactsunny.poc.graphsearch;

public class Edge {

    // The first vertex or one end of the edge
    private final Vertex v1;
    // The second vertex or the other end of the edge.
    private final Vertex v2;

    public Edge(Vertex v1, Vertex v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public Vertex getV1() {
        return v1;
    }

    public Vertex getV2() {
        return v2;
    }
}
