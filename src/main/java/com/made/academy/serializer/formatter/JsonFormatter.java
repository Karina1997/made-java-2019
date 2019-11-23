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
        appendQuoted(key, sb);
        sb.append(":");
    }

    @Override
    public void onObjectKeyLeave(String key, StringBuilder sb, int index, int size) {
    }

    @Override
    public void onObjectValueEnter(String value, StringBuilder sb, int index, int size) {
        appendQuoted(value, sb);
    }

    @Override
    public void onArrayItemEnter(String value, StringBuilder sb, int index, int size) {
        if (index > 0) sb.append(",");
        appendQuoted(value, sb);
    }

    @Override
    public void onArrayEnter(StringBuilder sb) {
        sb.append("[");
    }

    @Override
    public void onArrayLeave(StringBuilder sb) {
        sb.append("]");
    }

    private void appendQuoted(String s, StringBuilder sb) {
        appendWrapped(s, "\"", "\"", sb);
    }
}
