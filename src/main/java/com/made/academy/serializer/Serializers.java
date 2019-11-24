package com.made.academy.serializer;

import com.made.academy.serializer.formatter.JsonFormatter;
import com.made.academy.serializer.formatter.XmlFormatter;
import com.made.academy.serializer.reader.ObjectReaderImpl;

public class Serializers {
    public static Serializer newXmlSerializer() {
        return new SerializerImpl(new ObjectReaderImpl(), new XmlFormatter());
    }

    public static Serializer newJsonSerializer() {
        return new SerializerImpl(new ObjectReaderImpl(), new JsonFormatter());
    }
}
