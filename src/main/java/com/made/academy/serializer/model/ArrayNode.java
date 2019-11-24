package com.made.academy.serializer.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArrayNode extends Node {
    private final List<Node> items = new ArrayList<>();

    public ArrayNode add(Node value) {
        items.add(value);
        return this;
    }

    public Node get(Object key) {
        return items.get((Integer) key);
    }

    public Collection<Node> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return items.toString();
    }
}
