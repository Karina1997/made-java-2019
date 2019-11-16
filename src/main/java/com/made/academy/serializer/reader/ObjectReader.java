package com.made.academy.serializer.reader;

import com.made.academy.serializer.model.ObjectNode;

public interface ObjectReader {
    ObjectNode read(Object o);
}
