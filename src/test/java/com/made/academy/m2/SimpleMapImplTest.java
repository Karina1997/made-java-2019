package com.made.academy.m2;

import org.junit.Test;

import java.util.Collection;
import java.util.Set;

import static org.junit.Assert.*;

public class SimpleMapImplTest {

    @Test
    public void testPutOnKeyExist() {
        SimpleMap<String, String> m = new SimpleMapImpl<>();
        m.put("k1", "old");
        assertEquals("old", m.put("k1", "new"));
    }

    @Test
    public void testPutOnKeyNotExist() {
        SimpleMap<String, String> m = new SimpleMapImpl<>();
        m.put("k1", "old");
        assertNull(m.put("k2", "new"));
    }

    @Test
    public void testPutOnTwoEqualValues() {
        SimpleMap<String, String> m = new SimpleMapImpl<>();
        m.put("k1", "old");
        m.put("k2", "old");
        assertEquals(2, m.size());
    }

    @Test
    public void testGetOnKeyExist() {
        SimpleMap<String, String> m = new SimpleMapImpl<>();
        m.put("k1", "old");
        assertEquals("old", m.get("k1"));
    }

    @Test
    public void testGetOnKeyNotExist() {
        SimpleMap<String, String> m = new SimpleMapImpl<>();
        assertNull(m.get("k1"));
    }

    @Test
    public void testRemoveOnKeyExist() {
        SimpleMap<String, String> m = new SimpleMapImpl<>();
        m.put("k1", "old");
        assertEquals("old", m.remove("k1"));
        assertEquals(0, m.size());
    }

    @Test
    public void testRemoveOnKeyNotExist() {
        SimpleMap<String, String> m = new SimpleMapImpl<>();
        assertNull(m.remove("k1"));
    }

    @Test
    public void testContainsOnKeyExist() {
        SimpleMap<String, String> m = new SimpleMapImpl<>();
        m.put("k1", "old");
        assertTrue(m.contains("k1"));
    }

    @Test
    public void testContainsOnKeyNotExist() {
        SimpleMap<String, String> m = new SimpleMapImpl<>();
        m.put("k1", "old");
        assertFalse(m.contains("k2"));
    }

    @Test
    public void testSizeOnTwoEqualVals() {
        SimpleMap<String, String> m = new SimpleMapImpl<>();
        m.put("k1", "old");
        m.put("k1", "new");
        m.put("k2", "newest");
        assertEquals(2, m.size());
    }

    @Test
    public void testKeySet() {
        SimpleMap<String, String> m = new SimpleMapImpl<>();
        m.put("k1", "old");
        m.put("k1", "new");
        m.put("k2", "newest");

        Set<String> s = m.keySet();
        assertEquals(2, s.size());
        assertTrue(s.contains("k1"));
        assertTrue(s.contains("k2"));
    }

    @Test
    public void testValues() {
        SimpleMap<String, String> m = new SimpleMapImpl<>();
        m.put("k1", "old");
        m.put("k2", "new");
        m.put("k3", "newest");

        Collection<String> s = m.values();
        assertEquals(3, s.size());
        assertTrue(s.contains("old"));
        assertTrue(s.contains("new"));
        assertTrue(s.contains("newest"));
    }
}
