package com.made.academy.serializer.formatter;

import com.made.academy.serializer.model.ArrayNode;
import com.made.academy.serializer.model.Node;
import com.made.academy.serializer.model.ObjectNode;
import com.made.academy.serializer.model.ValueNode;

import java.util.Collection;
import java.util.Map;

public abstract class Formatter {
    public String format(ObjectNode tree) {
        StringBuilder sb = new StringBuilder();
        onRootObjectEnter(tree, sb);
        traverseObject(tree, sb);
        onRootObjectLeave(tree, sb);
        return sb.toString();
    }

    void onRootObjectEnter(ObjectNode objectNode, StringBuilder sb) {
    }

    void onRootObjectLeave(ObjectNode objectNode, StringBuilder sb) {
    }

    void onObjectEnter(ObjectNode objectNode, StringBuilder sb) {
    }

    void onObjectLeave(ObjectNode objectNode, StringBuilder sb) {
    }

    void onObjectKeyEnter(String key, StringBuilder sb, int index, int size) {
    }

    void onObjectKeyLeave(String key, StringBuilder sb, int index, int size) {
    }

    void onObjectValueEnter(String value, StringBuilder sb, int index, int size) {
    }

    void onArrayItemEnter(String value, StringBuilder sb, int index, int size) {
    }

    void onArrayEnter(StringBuilder sb) {
    }

    void onArrayLeave(StringBuilder sb) {
    }

    void onTreeNodeTypeUndefined() {
        throw new RuntimeException("Undefined node type");
    }

    private void traverseObject(ObjectNode objectNode, StringBuilder sb) {
        onObjectEnter(objectNode, sb);
        Collection<Map.Entry<String, Node>> entries = objectNode.getChildren().entrySet();
        int i = 0;
        for (Map.Entry<String, Node> e : entries) {
            String key = e.getKey();
            Node value = e.getValue();
            onObjectKeyEnter(key, sb, i, entries.size());
            if (value instanceof ValueNode) onObjectValueEnter(value.asString(), sb, i, entries.size());
            else traverseItemNode(value, sb);
            onObjectKeyLeave(e.getKey(), sb, i, objectNode.getChildren().entrySet().size());
            i++;
        }
        onObjectLeave(objectNode, sb);
    }

    private void traverseArray(ArrayNode arrayNode, StringBuilder sb) {
        onArrayEnter(sb);
        Collection<Node> values = arrayNode.getItems();
        int i = 0;
        for (Node value : values) {
            if (value instanceof ValueNode) onArrayItemEnter(value.asString(), sb, i, values.size());
            else traverseItemNode(value, sb);
            i++;
        }
        onArrayLeave(sb);
    }

    private void traverseItemNode(Node node, StringBuilder sb) {
        if (node instanceof ArrayNode) traverseArray((ArrayNode) node, sb);
        else if (node instanceof ObjectNode) traverseObject((ObjectNode) node, sb);
        else onTreeNodeTypeUndefined();
    }
}
