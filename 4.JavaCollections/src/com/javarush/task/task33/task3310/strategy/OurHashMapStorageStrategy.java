package com.javarush.task.task33.task3310.strategy;

import java.util.Arrays;

public class OurHashMapStorageStrategy implements StorageStrategy {
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    int size;
    int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    float loadFactor = DEFAULT_LOAD_FACTOR;

    @Override
    public boolean containsKey(Long key) {
        return getValue(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        return getKey(value) != null;
    }

    @Override
    public void put(Long key, String value) {
        int hash = hash(key);
        addEntry(hash, key, value, indexFor(hash, table.length));
    }

    @Override
    public Long getKey(String value) {
        for (Entry entry : table) {
            while (entry != null) {
                if (entry.value.equals(value)) {
                    return entry.key;
                }
                entry = entry.next;
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        Entry entry = getEntry(key);
        return entry != null ? entry.value : null;
    }

    int hash(Long k) {
        int h;
        return (k == null) ? 0 : (h = k.hashCode()) ^ (h >>> 16);
    }

    int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    Entry getEntry(Long key) {
        int hash = hash(key);
        int i = indexFor(hash, table.length);
        Entry entry = table[i];
        while (entry != null) {
            if (entry.hash == hash && entry.key.equals(key)) {
                return entry;
            }
            entry = entry.next;
        }
        return null;
    }

    void resize(int newCapacity) {
        threshold = threshold << 1;
        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable);
        table = newTable;
    }

    void transfer(Entry[] newTable) {
        for (int i = 0; i < table.length; i++) {
            Entry entry = table[i];
            while (entry != null) {
                int newIndex = indexFor(entry.hash, newTable.length);
                addToBucket(newTable, entry, newIndex);
                entry = entry.next;
            }
        }
    }

    void addEntry(int hash, Long key, String value, int bucketIndex) {
        createEntry(hash, key, value, bucketIndex);
    }

    void createEntry(int hash, Long key, String value, int bucketIndex) {
        Entry newEntry = new Entry(hash, key, value, null);
        addToBucket(table, newEntry, bucketIndex);
        if (++size > threshold) {
            resize(table.length << 1);
        }
    }

    private void addToBucket(Entry[] table, Entry entry, int bucketIndex) {
        Entry existingEntry = table[bucketIndex];
        if (existingEntry == null) {
            table[bucketIndex] = entry;
        } else {
            while (existingEntry.next != null) {
                existingEntry = existingEntry.next;
            }
            existingEntry.next = entry;
        }
    }
}
