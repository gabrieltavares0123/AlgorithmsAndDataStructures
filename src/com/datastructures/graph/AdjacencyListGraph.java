package com.datastructures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyListGraph {
    private final Map<AdjacencyListGraphVertex, List<AdjacencyListGraphVertex>> adjacencyList;
    
    public AdjacencyListGraph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addVertex(String label) {
        AdjacencyListGraphVertex vertex = new AdjacencyListGraphVertex(label);
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void removeVertex(String label) {
        AdjacencyListGraphVertex vertex = new AdjacencyListGraphVertex(label);
        adjacencyList.values().stream().forEach(e -> e.remove(vertex));
        adjacencyList.remove(vertex);
    }

    public void addEdge(String label1, String label2) {
        AdjacencyListGraphVertex v1 = new AdjacencyListGraphVertex(label1);
        AdjacencyListGraphVertex v2 = new AdjacencyListGraphVertex(label2);
        adjacencyList.get(v1).add(v2);
        adjacencyList.get(v2).add(v1);
    }

    public void removeEdge(String label1, String label2) {
        AdjacencyListGraphVertex v1 = new AdjacencyListGraphVertex(label1);
        AdjacencyListGraphVertex v2 = new AdjacencyListGraphVertex(label2);
        List<AdjacencyListGraphVertex> ev1 = adjacencyList.get(v1);
        List<AdjacencyListGraphVertex> ev2 = adjacencyList.get(v2);
        if (ev1 != null) {
            ev1.remove(v2);
        }
        if (ev2 != null) {
            ev2.remove(v2);
        }
    }

    public List<AdjacencyListGraphVertex> getAdjacentVertices(String label) {
        AdjacencyListGraphVertex v = new AdjacencyListGraphVertex(label);
        return adjacencyList.get(v);
    }

    public static AdjacencyListGraph createGraph(List<String> V, List<AdjacencyListGraphEdge> E) {
        AdjacencyListGraph graph = new AdjacencyListGraph();
        for (String v : V) {
            graph.addVertex(v);
        }
        for (AdjacencyListGraphEdge e : E) {
            graph.addEdge(e.getLabel1(), e.getLabel2());
        }

        return graph;
    }
}
