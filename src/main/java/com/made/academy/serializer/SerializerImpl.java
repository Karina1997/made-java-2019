package com.made.academy.serializer;

import com.made.academy.serializer.formatter.Formatter;
import com.made.academy.serializer.model.ObjectNode;
import com.made.academy.serializer.reader.ObjectReader;

public class SerializerImpl implements Serializer {
    private final ObjectReader objectReader;
    private final Formatter formatter;

    public SerializerImpl(ObjectReader objectReader, Formatter formatter) {
        this.objectReader = objectReader;
        this.formatter = formatter;
    }

    @Override
    public String serialize(Object o) {
        ObjectNode tree = objectReader.read(o);
        return formatter.format(tree);
    }
}
