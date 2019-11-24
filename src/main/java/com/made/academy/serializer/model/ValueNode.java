package com.made.academy.serializer.model;

public class ValueNode extends Node {
    private final String value;

    public ValueNode(String value) {
        this.value = value;
    }

    @Override
    public Node get(Object key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return value;
    }
}
