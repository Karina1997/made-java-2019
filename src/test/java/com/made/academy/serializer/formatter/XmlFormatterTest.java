package com.made.academy.serializer.formatter;

import static com.made.academy.serializer.TestUtils.buildPersonObjectTree;
import static com.made.academy.serializer.TestUtils.normalizeString;
import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class XmlFormatterTest {
    @Test
    public void testFormatXml() {
        String xml = "<Person>\n" +
                "    <firstName>Joshua</firstName>\n" +
                "    <lastName>Bloch</lastName>\n" +
                "    <address> \n" +
                "        <city>New York</city>\n" +
                "        <postalCode>10035</postalCode>\n" +
                "    </address>\n" +
                "    <phoneNumbers>\n" +
                "        <1>123-1234-523</1>\n" +
                "        <2>432-23-232-23</2>\n" +
                "    </phoneNumbers>\n" +
                "</Person>";

        Formatter formatter = new XmlFormatter();
        String s = formatter.format(buildPersonObjectTree());
        
        assertEquals(normalizeString(xml), normalizeString(s));
    }
}
