package com.made.academy.m2;

import java.util.*;
import java.util.stream.Collectors;

class SimpleMapImpl<K, V> implements SimpleMap<K, V> {

    private static final int DEFAULT_CAPACITY = 17;

    private Entry<K, V>[] table;

    private static class Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> next;
        private Entry<K, V> previous;

        Entry(K key, V value, Entry<K, V> next, Entry<K, V> previous) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return value;
        }
    }

    public SimpleMapImpl() {
        this(DEFAULT_CAPACITY);
    }

    public SimpleMapImpl(int capacity) {
        table = new Entry[capacity];
    }

    @Override
    public V put(K key, V value) {
        int hash = hash(key);
        Entry<K, V> oldEntry = findEntry(key, hash);
        Entry<K, V> newEntry = new Entry<>(key, value, null, oldEntry);

        V oldValue;
        if (oldEntry == null) {
            table[hash] = newEntry;
            oldValue = null;
        } else {
            oldValue = oldEntry.value;
            oldEntry.value = value;
        }

        return oldValue;
    }

    @Override
    public V get(K key) {
        int hash = hash(key);
        Entry<K, V> entry = findEntry(key, hash);
        return entry != null ? entry.value : null;
    }

    @Override
    public V remove(K key) {
        int hash = hash(key);
        Entry<K, V> entry = findEntry(key, hash);

        if (entry == null) throw new NoSuchElementException();

        Entry<K, V> previous = entry.previous;
        Entry<K, V> next = entry.next;
        if (previous == null) {
            table[hash] = null;
        } else {
            previous.next = next;
        }

        return entry.value;
    }

    @Override
    public boolean contains(K key) {
        return keySet().contains(key);
    }

    @Override
    public int size() {
        return entries().size();
    }

    @Override
    public Set<K> keySet() {
        return entries().stream()
                .map(Entry::getKey)
                .collect(Collectors.toSet());
    }

    @Override
    public Collection<V> values() {
        return entries().stream()
                .map(Entry::getValue)
                .collect(Collectors.toList());
    }

    private Collection<Entry<K, V>> entries() {
        Collection<Entry<K, V>> entries = new ArrayList<>();
        for (Entry<K, V> e : table) {
            if (e != null) {
                Entry<K, V> entry = e;
                while (entry != null) {
                    entries.add(entry);
                    entry = entry.next;
                }
            }
        }
        return entries;
    }

    private Entry<K, V> findEntry(K key, int hash) {
        Entry<K, V> current = table[hash];
        while (current != null) {
            if (current.key.equals(key)) {
                return current;
            }
            current = current.next;
        }

        return null;
    }

    private int hash(K key) {
        if (key == null) throw new IllegalArgumentException();

        return Math.abs(key.hashCode()) % table.length;
    }
}