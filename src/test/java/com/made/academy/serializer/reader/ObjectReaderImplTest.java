package com.made.academy.serializer.reader;

import static com.made.academy.serializer.TestUtils.buildPersonObject;
import static junit.framework.TestCase.assertEquals;

import com.made.academy.serializer.model.ObjectNode;

import org.junit.Test;

public class ObjectReaderImplTest {
    @Test
    public void testParse() {
        ObjectReader objectReader = new ObjectReaderImpl();
        ObjectNode root = objectReader.read(buildPersonObject());

        assertEquals("Joshua", root.get("firstName").asString());
        assertEquals("Bloch", root.get("lastName").asString());
        assertEquals("New York", root.get("address").get("city").asString());
        assertEquals("10035", root.get("address").get("postalCode").asString());
        assertEquals("123-1234-523", root.get("phoneNumbers").asArray().get(0).asString());
        assertEquals("432-23-232-23", root.get("phoneNumbers").asArray().get(1).asString());
    }
}
