package com.datastructures.graph;

import java.util.Objects;

public class AdjacencyListGraphVertex {
    private final String label;

    public AdjacencyListGraphVertex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdjacencyListGraphVertex that = (AdjacencyListGraphVertex) o;
        return label.equals(that.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }
}
