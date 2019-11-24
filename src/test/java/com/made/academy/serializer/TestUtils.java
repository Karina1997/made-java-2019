package com.made.academy.serializer;

import java.util.List;

import com.made.academy.serializer.model.ObjectNode;
import com.made.academy.serializer.model.ValueNode;

import java.util.Arrays;

public class TestUtils {
    public static class Person {
        private final String firstName;
        private final String lastName;
        private final Address address;
        private final List<String> phoneNumbers;

        public Person(String firstName, String lastName, Address address, List<String> phoneNumbers) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.phoneNumbers = phoneNumbers;
        }
    }

    public static class Address {
        private final String city;
        private final String postalCode;

        public Address(String city, String postalCode) {
            this.city = city;
            this.postalCode = postalCode;
        }
    }

    public static Person buildPersonObject() {
        Address address = new Address("New York", "10035");
        List<String> phoneNumbers = Arrays.asList("123-1234-523", "432-23-232-23");
        return new Person("Joshua", "Bloch", address, phoneNumbers);
    }

    public static ObjectNode buildPersonObjectTree() {
        ObjectNode root = new ObjectNode();
        root.setName("Person");
        root.putKeyValue("firstName", "Joshua")
                .putKeyValue("lastName", "Bloch");

        root.putObject("address")
                .putKeyValue("city", "New York")
                .putKeyValue("postalCode", "10035")
                .setName("Address");

        root.putArray("phoneNumbers")
                .add(new ValueNode("123-1234-523"))
                .add(new ValueNode("432-23-232-23"));

        return root;
    }

    public static String normalizeString(String s) {
        return s.replaceAll("[\\s\\n\\t\\r]+", "");
    }
}
