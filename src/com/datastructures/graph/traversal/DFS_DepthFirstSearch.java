package com.datastructures.graph.traversal;

import com.datastructures.graph.AdjacencyListGraph;
import com.datastructures.graph.AdjacencyListGraphEdge;
import com.datastructures.graph.AdjacencyListGraphVertex;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class DFS_DepthFirstSearch {
    public static Set<String> dfs(AdjacencyListGraph graph, String rootLabel) {
        Set<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();
        stack.push(rootLabel);

        while (!stack.isEmpty()) {
            String current = stack.pop();
            if (!visited.contains(current)) {
                visited.add(current);

                for (AdjacencyListGraphVertex v : graph.getAdjacentVertices(current)) {
                    stack.push(v.getLabel());
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

        Set<String> result = DFS_DepthFirstSearch.dfs(graph, "Bob");

        System.out.println(expected.equals(result));
    }
}
