package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

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
        //напишите тут ваш код
        int count=0;
        for (Entry<K, List<V>> m: map.entrySet()             ) {
            count += m.getValue().size();
        }
        return count;
    }

    @Override
    public V put(K key, V value) {
        //напишите тут ваш код
        V v = map.get(key) == null ? null : map.get(key).get(map.get(key).size() - 1);
        if (map.get(key) == null)
            map.put(key, new ArrayList<>());

        if (map.get(key).size() >= repeatCount) {
            map.get(key).remove(0);
        }
        map.get(key).add(value);
        return v;
    }

    @Override
    public V remove(Object key) {
        //напишите тут ваш код
        if (map.get(key) == null)
            return null;
        else if (map.get(key).size() == 0) {
            map.remove(key);
            return null;
        } else {
            V v = map.get(key).remove(0);
            if (map.get(key).size()==0)
                map.remove(key);
            return v;
        }
    }

    @Override
    public Set<K> keySet() {
        //напишите тут ваш код
        Set<K> keys = new HashSet<>();
        for (Entry<K, List<V>> m : map.entrySet()) {
            keys.add(m.getKey());
        }
        return keys;
    }

    @Override
    public Collection<V> values() {
        //напишите тут ваш код
        ArrayList<V> val = new ArrayList<>();
        for (Entry<K, List<V>> m : map.entrySet()) {
            val.addAll(m.getValue());
        }
        return val;
    }

    @Override
    public boolean containsKey(Object key) {
        //напишите тут ваш код
        return map.get(key) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        //напишите тут ваш
        for (Entry<K, List<V>> m : map.entrySet()) {
            for (V v:m.getValue()                 ) {
                if (value.equals(v))
                    return true;
            }
        }
        return false;
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
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}