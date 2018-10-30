package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        return map.values()
                .stream()
                .map(List::size)
                .mapToInt(Integer::intValue)
                .sum();
    }

    @Override
    public V put(K key, V value) {
        List<V> list = map.get(key);
        if (list != null) {
            if (list.size() == repeatCount) {
                list.remove(0);
            }
            V returnValue = list.get(list.size() - 1);
            list.add(value);
            return returnValue;
        } else {
            list = new LinkedList<>();
            list.add(value);
            map.put(key, list);
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        List<V> list = map.get(key);
        if (list != null) {
            V returnValue = list.remove(0);
            if (list.isEmpty()) {
                map.remove(key);
            }
            return returnValue;
        }
        return null;
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        return map.values()
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.values()
                .stream()
                .anyMatch(list -> list.contains(value));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.length() > 2 ? sb.substring(0, sb.length() - 2) : sb.toString();
        return substring + "}";
    }
}