package com.made.academy.m2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

class SimpleMapImpl<K, V> implements SimpleMap<K, V> {

    private static final int DEFAULT_CAPACITY = 17;

    private Entry<K, V>[] table;

    public static class Entry<K, V> {
        private final K key;
        private final V value;
        private Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
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
        if (key == null)
            return null;

        int hash = hash(key);
        Entry<K, V> newEntry = new Entry<>(key, value, null);

        if (table[hash] == null) {
            table[hash] = newEntry;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = table[hash];

            while (current != null) {
                if (current.key.equals(key)) {
                    V oldValue;
                    if (previous == null) {
                        oldValue = current.value;
                        newEntry.next = current.next;
                        table[hash] = newEntry;
                    } else {
                        oldValue = previous.next.value;
                        newEntry.next = current.next;
                        previous.next = newEntry;
                    }

                    return oldValue;
                }
                previous = current;
                current = current.next;
            }

            previous.next = newEntry;
        }

        return null;
    }

    @Override
    public V get(K key) {
        int hash = hash(key);
        if (table[hash] == null) {
            return null;
        } else {
            Entry<K, V> temp = table[hash];
            while (temp != null) {
                if (temp.key.equals(key))
                    return temp.value;
                temp = temp.next;
            }
            return null;
        }
    }

    @Override
    public V remove(K deleteKey) {
        int hash = hash(deleteKey);

        if (table[hash] == null) {
            return null;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = table[hash];

            while (current != null) {
                if (current.key.equals(deleteKey)) {
                    V oldValue;
                    if (previous == null) {
                        oldValue = table[hash].value;
                        table[hash] = table[hash].next;
                    } else {
                        oldValue = previous.next.value;
                        previous.next = current.next;
                    }
                    return oldValue;
                }
                previous = current;
                current = current.next;
            }
            return null;
        }
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

    public Collection<Entry<K, V>> entries() {
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

    private int hash(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }
}