package com.made.academy.serializer.formatter;

import static com.made.academy.serializer.TestUtils.buildPersonObjectTree;
import static com.made.academy.serializer.TestUtils.normalizeString;
import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class JsonFormatterTest {
    @Test
    public void testFormatJson() {
        String json = "{\n" +
                "   \"firstName\": \"Joshua\",\n" +
                "   \"lastName\": \"Bloch\",\n" +
                "   \"address\": { \n" +
                "       \"city\": \"New York\",\n" +
                "       \"postalCode\": \"10035\"\n" +
                "   },\n" +
                "   \"phoneNumbers\": [\n" +
                "       \"123-1234-523\",\n" +
                "       \"432-23-232-23\"\n" +
                "   ]\n" +
                "}";

        Formatter formatter = new JsonFormatter();
        String s = formatter.format(buildPersonObjectTree());

        assertEquals(normalizeString(json), normalizeString(s));
    }
}
