package com.datastructures.graph.traversal;

import com.datastructures.graph.AdjacencyListGraph;
import com.datastructures.graph.AdjacencyListGraphEdge;
import com.datastructures.graph.AdjacencyListGraphVertex;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BFS_BreadthFirstSearch {
    public static Set<String> bfs(AdjacencyListGraph graph, String rootLabel) {
        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(rootLabel);
        visited.add(rootLabel);
        while (!queue.isEmpty()) {
            String current = queue.poll();
            for (AdjacencyListGraphVertex v : graph.getAdjacentVertices(current)) {
                if (!visited.contains(v.getLabel())) {
                    visited.add(v.getLabel());
                    queue.add(v.getLabel());
                }
            }
        }

        return visited;
    }

    public static void main(String[] args) {
        List<String> V = Arrays.asList("Bob", "Alice", "Mark", "Rob", "Maria");
        List<AdjacencyListGraphEdge> E = Arrays.asList(
                new AdjacencyListGraphEdge("Bob", "Alice"),
                new AdjacencyListGraphEdge("Bob", "Rob"),
                new AdjacencyListGraphEdge("Alice", "Mark"),
                new AdjacencyListGraphEdge("Rob", "Mark"),
                new AdjacencyListGraphEdge("Alice", "Maria"),
                new AdjacencyListGraphEdge("Rob", "Maria")
        );
        AdjacencyListGraph graph = AdjacencyListGraph.createGraph(V, E);

        assertOutput(graph);
    }

    public static void assertOutput(AdjacencyListGraph graph) {
        Set<String> expected = new HashSet<>();
        expected.add("Bob");
        expected.add("Rob");
        expected.add("Maria");
        expected.add("Alice");
        expected.add("Mark");

        Set<String> result = BFS_BreadthFirstSearch.bfs(graph, "Bob");

        System.out.println(expected.equals(result));
    }
}
