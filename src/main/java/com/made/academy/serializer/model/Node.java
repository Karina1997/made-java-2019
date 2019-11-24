package com.made.academy.serializer.model;

public abstract class Node {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public ArrayNode asArray() {
        return (ArrayNode) this;
    }

    public String asString() {
        return this.toString();
    }

    public abstract Node get(Object key);

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                '}';
    }
}
