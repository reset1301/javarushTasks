package com.javarush.task.task34.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<K, V>();   //TODO add your code here

//    public Cache(K key) {

//    }

    public V getByKey(K key, Class<V> clazz) throws Exception {
        //TODO add your code here
//        if (cache.get(key) == null) {
//            Constructor constr = clazz.getClass().getConstructor(key.getClass());
//            cache.put(key, (V) constr.newInstance(key));
//        }
//        return cache.get(key);
        V val = cache.get(key);
        if (val != null) {
            return val;
        } else {
            Constructor constructor = clazz.getDeclaredConstructor(key.getClass());
            val = (V) constructor.newInstance(key);
            put(val);
        }

        return val;
    }

    public boolean put(V obj) {
        //TODO add your code here
        int cacheSize = size();
//        try {
//            Method getKey = (Method) obj.getClass().getDeclaredMethod("getKey", null);
//            getKey.setAccessible(true);
//            K key = (K) getKey.invoke(obj, null);
//            cache.put(key, obj);
//            if (cacheSize < cache.size())
//                return true;
//        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
//            e.printStackTrace();
//            return false;
//        }
//        return false;
        Method method = null;
        try {
            method = obj.getClass().getDeclaredMethod("getKey");
            method.setAccessible(true);

            cache.put((K) method.invoke(obj), obj);
            return cache.containsKey((K) method.invoke(obj));
        } catch (Exception ignore) {
        }

        return false;
    }

    public int size() {
        return cache.size();
    }
}
