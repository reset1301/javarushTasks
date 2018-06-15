package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class AmigoSet<E> extends AbstractSet implements Serializable, Cloneable, Set {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        int initialCapacity = (Math.ceil(collection.size() / .75f) > 16) ? (int) Math.ceil(collection.size() / .75f) : 16;
        map = new HashMap<E, Object>(initialCapacity);
        for (E e : collection) {
            add(e);
        }
    }

    @Override
    public boolean add(Object e) {
        return map.put((E) e, PRESENT) == null;
    }

    @Override
    public Iterator iterator() {
        return map.keySet().iterator();
    }

    @Override
    public void forEach(Consumer action) {

    }

    @Override
    public boolean removeIf(Predicate filter) {
        return false;
    }

    @Override
    public Spliterator spliterator() {
        return null;
    }

    @Override
    public Stream stream() {
        return null;
    }

    @Override
    public Stream parallelStream() {
        return null;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return super.contains(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) != null;
    }

    @Override
    public Object clone() {
        try {
            AmigoSet<Object> set = new AmigoSet<>();
            set.map = (HashMap<Object, Object>) this.map.clone();
            return set;
        } catch (Exception e) {
            throw new InternalError();
        }
    }

    private void writeObject(ObjectOutputStream oos) throws IOException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        oos.defaultWriteObject();
        oos.writeObject(map.size());

        for (E e : map.keySet()) {
            oos.writeObject(e);
        }

        oos.writeObject(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
        oos.writeObject(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();

        int size = (int) ois.readObject();
        Set<E> set = new HashSet<>();

        for (int i = 0; i < size; i++) {
            set.add((E) ois.readObject());
        }

        int capacity = (int) ois.readObject();
        float loadFactor = (float) ois.readObject();
        map = new HashMap<>(capacity, loadFactor);

        for (E e : set) {
            map.put(e, PRESENT);
        }
    }
}
