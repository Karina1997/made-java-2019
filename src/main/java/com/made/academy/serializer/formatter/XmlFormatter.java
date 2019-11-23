package com.made.academy.serializer.formatter;

import com.made.academy.serializer.model.ObjectNode;

public class XmlFormatter extends Formatter {
    @Override
    void onRootObjectEnter(ObjectNode objectNode, StringBuilder sb) {
        appendOpenTag(objectNode.getName(), sb);
    }

    @Override
    void onRootObjectLeave(ObjectNode objectNode, StringBuilder sb) {
        appendCloseTag(objectNode.getName(), sb);
    }

    @Override
    public void onObjectKeyEnter(String key, StringBuilder sb, int index, int size) {
        appendOpenTag(key, sb);
    }

    @Override
    public void onObjectKeyLeave(String key, StringBuilder sb, int index, int size) {
        appendOpenTag(key, sb);
    }

    @Override
    public void onObjectValueEnter(String value, StringBuilder sb, int index, int size) {
        sb.append(value);
    }

    @Override
    public void onArrayItemEnter(String value, StringBuilder sb, int index, int size) {
        String tag = String.valueOf(index + 1);
        appendOpenTag(tag, sb);
        sb.append(value);
        appendCloseTag(tag, sb);
    }

    private void appendCloseTag(String name, StringBuilder sb) {
        appendWrapped(name, "</", ">", sb);
    }

    private void appendOpenTag(String name, StringBuilder sb) {
        appendWrapped(name, "<", ">", sb);
    }
}
