package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever {
    LRUCache<Long, Object> cache;
    OriginalRetriever retriever;
//    Storage storage;

    public CachingProxyRetriever(Storage storage) {
        retriever = new OriginalRetriever(storage);
        cache = new LRUCache<Long, Object>(0);
    }

    @Override
    public Object retrieve(long id) {
        Object value = cache.find(id);
        if (value != null)
            return value;
        value = retriever.retrieve(id);
        cache.set(id, value);
        return value;
    }
}
