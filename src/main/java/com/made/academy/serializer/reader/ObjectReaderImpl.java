package com.made.academy.serializer.reader;

import com.made.academy.serializer.model.ArrayNode;
import com.made.academy.serializer.model.ObjectNode;
import com.made.academy.serializer.model.ValueNode;

import java.lang.reflect.Field;
import java.util.Collection;

import static java.lang.String.valueOf;

public class ObjectReaderImpl implements ObjectReader {
    @Override
    public ObjectNode read(Object o) {
        try {
            ObjectNode root = new ObjectNode();
            readObject(o, root);
            return root;
        } catch (IllegalAccessException e) {
            throw new ReadObjectException(e);
        }
    }

    private void readObject(Object o, ObjectNode objectNode) throws IllegalAccessException {
        objectNode.setName(o.getClass().getSimpleName());
        for (Field field : o.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            String key = field.getName();
            Object value = field.get(o);
            if (isValue(value)) {
                objectNode.putKeyValue(key, valueOf(value));
            } else if (isCollection(value)) {
                readArray(value, objectNode.putArray(key));
            } else {
                readObject(value, objectNode.putObject(key));
            }
        }
    }

    private void readArray(Object o, ArrayNode arrayNode) throws IllegalAccessException {
        for (Object e : ((Collection) o)) {
            if (isValue(e)) {
                arrayNode.add(new ValueNode(valueOf(e)));
            } else if (isCollection(e)) {
                ArrayNode nestedArray = new ArrayNode();
                arrayNode.add(nestedArray);
                readArray(e, nestedArray);
            } else {
                ObjectNode nestedObject = new ObjectNode();
                arrayNode.add(nestedObject);
                readObject(e, nestedObject);
            }
        }
    }

    private boolean isValue(Object e) {
        return e == null || e.getClass().isPrimitive() || e instanceof String;
    }

    private boolean isCollection(Object e) {
        return e.getClass().isArray() || e instanceof Collection;
    }
}
