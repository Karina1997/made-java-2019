package com.made.academy.serializer.formatter;

import com.made.academy.serializer.model.ObjectNode;

public class XmlFormatter extends Formatter {
    @Override
    void onRootObjectEnter(ObjectNode objectNode, StringBuilder sb) {
        sb.append("<").append(objectNode.getName()).append(">");
    }

    @Override
    void onRootObjectLeave(ObjectNode objectNode, StringBuilder sb) {
        sb.append("</").append(objectNode.getName()).append(">");
    }

    @Override
    public void onObjectKeyEnter(String key, StringBuilder sb, int index, int size) {
        sb.append("<").append(key).append(">");
    }

    @Override
    public void onObjectKeyLeave(String key, StringBuilder sb, int index, int size) {
        sb.append("</").append(key).append(">");
    }

    @Override
    public void onObjectValueEnter(String value, StringBuilder sb, int index, int size) {
        sb.append(value);
    }

    @Override
    public void onArrayItemEnter(String value, StringBuilder sb, int index, int size) {
        sb.append("<").append(index + 1).append(">")
                .append(value)
                .append("</").append(index + 1).append(">");
    }
}
