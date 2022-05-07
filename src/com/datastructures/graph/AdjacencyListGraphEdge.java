package com.datastructures.graph;

import java.util.Objects;

public class AdjacencyListGraphEdge {
    private final String label1;
    private final String label2;

    public AdjacencyListGraphEdge(String label1, String label2) {
        this.label1 = label1;
        this.label2 = label2;
    }

    public String getLabel1() {
        return label1;
    }

    public String getLabel2() {
        return label2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdjacencyListGraphEdge that = (AdjacencyListGraphEdge) o;
        return label1.equals(that.label1) && label2.equals(that.label2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label1, label2);
    }
}
