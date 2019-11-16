package com.made.academy.serializer.formatter;

import com.made.academy.serializer.model.ObjectNode;

public class JsonFormatter extends Formatter {
    @Override
    public void onObjectEnter(ObjectNode objectNode, StringBuilder sb) {
        sb.append("{");
    }

    @Override
    public void onObjectLeave(ObjectNode objectNode, StringBuilder sb) {
        sb.append("}");
    }

    @Override
    public void onObjectKeyEnter(String key, StringBuilder sb, int index, int size) {
        if (index > 0) sb.append(",");
        sb.append("\"")
                .append(key)
                .append("\"")
                .append(":");
    }

    @Override
    public void onObjectKeyLeave(String key, StringBuilder sb, int index, int size) {
    }

    @Override
    public void onObjectValueEnter(String value, StringBuilder sb, int index, int size) {
        sb.append("\"")
                .append(value)
                .append("\"");
    }

    @Override
    public void onArrayItemEnter(String value, StringBuilder sb, int index, int size) {
        if (index > 0) sb.append(",");
        sb.append("\"")
                .append(value)
                .append("\"");
    }

    @Override
    public void onArrayEnter(StringBuilder sb) {
        sb.append("[");
    }

    @Override
    public void onArrayLeave(StringBuilder sb) {
        sb.append("]");
    }
}
