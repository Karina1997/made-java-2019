package com.made.academy.serializer.model;

import java.util.*;

public class ObjectNode extends Node {
    private final Map<String, Node> children = new HashMap<>();

    public Map<String, Node> getChildren() {
        return children;
    }

    public ObjectNode putKeyValue(String key, String value) {
        children.put(key, new ValueNode(value));
        return this;
    }

    public ArrayNode putArray(String key) {
        ArrayNode arrayNode = new ArrayNode();
        children.put(key, arrayNode);
        return arrayNode;
    }

    public ObjectNode putObject(String key) {
        ObjectNode objectNode = new ObjectNode();
        children.put(key, objectNode);
        return objectNode;
    }

    @Override
    public Node get(Object key) {
        return children.get(key);
    }

    @Override
    public String toString() {
        return children.toString();
    }
}
