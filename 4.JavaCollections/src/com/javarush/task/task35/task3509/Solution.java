package com.javarush.task.task35.task3509;

import java.util.*;


/*
Collections & Generics
*/
public class Solution<T> {

    public static void main(String[] args) {
    }

    public static <T> ArrayList<T> newArrayList(T... elements) {
        //напишите тут ваш код
        List<T> list = new ArrayList<>(elements.length);
//        for (Object o : elements) {
        Collections.addAll(list, elements);
//        }
        return (ArrayList) list;
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        //напишите тут ваш код
        Set<T> set = new HashSet();
        Collections.addAll(set, elements);
        return (HashSet) set;
    }

    public static <K, V> HashMap<K, V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        //напишите тут ваш код
        if (keys.size() != values.size())
            throw new IllegalArgumentException();
        HashMap<K, V> set = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            set.put(keys.get(i), values.get(i));
        }
        return set;
    }
}
