package com.javarush.task.task33.task3310.strategy;

import com.javarush.task.task33.task3310.ExceptionHandler;

import java.io.IOException;

//public class FileStorageStrategy implements StorageStrategy {
//    static final int DEFAULT_INITIAL_CAPACITY = 16;
//    static final long DEFAULT_BUCKET_SIZE_LIMIT = 10000l;
//    FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
//    int size;
//    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
//    long maxBucketSize;
//
//    public long getBucketSizeLimit() {
//        return bucketSizeLimit;
//    }
//
//    public void setBucketSizeLimit(long bucketSizeLimit) {
//        this.bucketSizeLimit = bucketSizeLimit;
//    }
//
//    @Override
//    public boolean containsKey(Long key) {
//        return getEntry(key) != null;
//    }
//
//    @Override
//    public boolean containsValue(String value) {
//        if (value == null)
//            return false;
//        for (FileBucket aTable : table) {
//            try {
//                for (Entry e = aTable.getEntry(); e != null; e = e.next)
//                    if (value.equals(e.value))
//                        return true;
//            } catch (IOException | ClassNotFoundException e) {
//                ExceptionHandler.log(e);
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public void put(Long key, String value) {
//        addEntry(hash(key), key, value, indexFor(hash(key), table.length));
//    }
//
//    @Override
//    public Long getKey(String value) {
//        if (value == null)
//            return 0l;
//        for (FileBucket fb : table) {
//            Entry entry = null;
//            try {
//                entry = fb.getEntry();
//            } catch (IOException | ClassNotFoundException e) {
//                ExceptionHandler.log(e);
//            }
//
//            if (entry.getValue().equals(value))
//                return entry.getKey();
//        }
//        return null;
//    }
//
//    @Override
//    public String getValue(Long key) {
//        return null == getEntry(key) ? null : getEntry(key).getValue();
//    }
//
//    public int hash(Long k) {
//        return k.hashCode();
//    }
//
//    public int indexFor(int hash, int length) {
//        return (hash % length);
//    }
//
//    public Entry getEntry(Long key) {
//        if (size == 0) {
//            return null;
//        }
//        int hash = (key == null) ? 0 : hash(key);
//        try {
//            for (Entry e = table[indexFor(hash, table.length)].getEntry();
//                 e != null;
//                 e = e.next) {
//                Object k;
//                if (e.hash == hash &&
//                        ((k = e.key) == key || (key != null && key.equals(k))))
//                    return e;
//            }
//        } catch (IOException | ClassNotFoundException e) {
//            ExceptionHandler.log(e);
//        }
//        return null;
//    }
//
//    public void transfer(FileBucket[] newTable) {
//        int newCapacity = newTable.length;
//        for (FileBucket e : table) {
//            while (null != e) {
//                Entry next = null;
//                try {
//                    next = e.getEntry().next;
//                    int i = indexFor(e.getEntry().hash, newCapacity);
//                    e.getEntry().next = newTable[i].getEntry();
//                    newTable[i] = e;
//                    e.putEntry(next);
//                } catch (IOException | ClassNotFoundException e1) {
//                    ExceptionHandler.log(e1);
//                }
//            }
//        }
//    }
//
//    public void addEntry(int hash, Long key, String value, int bucketIndex) {
//        try {
//            Entry entry = table[bucketIndex].getEntry();
//            table[bucketIndex].putEntry(new Entry(hash, key, value, entry));
//        } catch (IOException | ClassNotFoundException e) {
//            ExceptionHandler.log(e);
//        }
//        size++;
//        if (table[bucketIndex].getFileSize() > bucketSizeLimit) resize(2 * table.length);
//    }
//
//    public void createEntry(int hash, Long key, String value, int bucketIndex) {
//        Entry e = null;
//        try {
//            e = table[bucketIndex].getEntry();
//            FileBucket fb = new FileBucket();
//            fb.putEntry(new Entry(hash, key, value, e));
//            table[bucketIndex] = fb;
//        } catch (IOException | ClassNotFoundException e1) {
//            ExceptionHandler.log(e1);
//        }
//        size++;
//    }
//
//
//    public void resize(int newCapacity) {
//        FileBucket[] newTable = new FileBucket[newCapacity];
//        transfer(newTable);
//        table = newTable;
////        FileBucket[] oldTable = table;
////        int oldCapacity = oldTable.length;
////        if (oldCapacity == (1 << 30)) {
////            threshold = Integer.MAX_VALUE;
////            return;
////        }
////        FileBucket[] newTable = new FileBucket[newCapacity];
////        transfer(newTable);
////        table = newTable;
////        threshold = (int) Math.min(newCapacity * loadFactor, (1 << 30) + 1);
//    }
//
//}
public class FileStorageStrategy implements StorageStrategy{
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
    private int size;
    static final long DEFAULT_BUCKET_SIZE_LIMIT = 10000l;
    long maxBucketSize;

    public FileStorageStrategy() throws IOException {
        for (int i = 0; i < DEFAULT_INITIAL_CAPACITY; i++) {
            table[i] = new FileBucket();
        }
    }

    private int hash(Long k) {
        long h = k;
        h ^= (h >>> 20) ^ (h >>> 12);
        return (int)(h ^ (h >>> 7) ^ (h >>> 4));
    }

    private int indexFor(int hash, int length) {
        return hash % (length - 1);
    }

    private Entry getEntry(Long key) throws IOException, ClassNotFoundException {
        int hash = hash(key);
        int index = indexFor(hash, table.length);
        if (table[index] != null) {
            Entry entry = table[index].getEntry();
            while (entry != null) {
                if (entry.getKey().equals(key)) {
                    return entry;
                }
                entry = entry.next;
            }
        }
        return null;
    }

    private void resize(int newCapacity) throws IOException, ClassNotFoundException {
        FileBucket[] newTable = new FileBucket[newCapacity];
        transfer(newTable);
        table = newTable;
    }

    private void transfer(FileBucket[] newTable) throws IOException, ClassNotFoundException {
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) continue;
            Entry entry = table[i].getEntry();
            while (entry != null) {
                Entry next = entry.next;
                int newIndex = indexFor(entry.hash, newTable.length);
                if (newTable[newIndex] == null) {
                    entry.next = null;
                    newTable[newIndex] = new FileBucket();
                }
                else {
                    entry.next = newTable[newIndex].getEntry();
                }
                newTable[newIndex].putEntry(entry);
                entry = next;
            }
            table[i].remove();
        }
    }

    private void addEntry(int hash, Long key, String value, int bucketIndex) throws IOException, ClassNotFoundException {
        Entry entry = table[bucketIndex].getEntry();
        table[bucketIndex].putEntry(new Entry(hash, key, value, entry));
        size++;
        if (table[bucketIndex].getFileSize() > bucketSizeLimit) resize(2 * table.length);
    }

    private void createEntry(int hash, Long key, String value, int bucketIndex) throws IOException {
        table[bucketIndex] = new FileBucket();
        table[bucketIndex].putEntry(new Entry(hash, key, value, null));
        size++;
    }

    @Override
    public boolean containsKey(Long key) {
        try {
            return getEntry(key) != null;
        } catch (IOException | ClassNotFoundException e) {
            ExceptionHandler.log(e);
        }
        return false;
    }

    @Override
    public boolean containsValue(String value) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) continue;
            Entry entry = null;
            try {
                entry = table[i].getEntry();
            } catch (IOException | ClassNotFoundException e) {
                ExceptionHandler.log(e);
            }
            while (entry != null) {
                if (entry.value.equals(value)) return true;
                entry = entry.next;
            }
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        int hash = hash(key);
        int index = indexFor(hash, table.length);
        if (table[index] != null) {
            Entry entry = null;
            try {
                entry = table[index].getEntry();
            } catch (IOException | ClassNotFoundException e) {
                ExceptionHandler.log(e);
            }
            while (entry != null) {
                if (entry.getKey().equals(key)) {
                    entry.value = value;
                    return;
                }
                entry = entry.next;
            }
            try {
                addEntry(hash, key, value, index);
            } catch (IOException | ClassNotFoundException e) {
                ExceptionHandler.log(e);
            }
        }
        else {
            try {
                createEntry(hash, key, value, index);
            } catch (IOException e) {
                ExceptionHandler.log(e);
            }
        }
    }

    @Override
    public Long getKey(String value) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) continue;
            Entry entry = null;
            try {
                entry = table[i].getEntry();
            } catch (IOException | ClassNotFoundException e) {
                ExceptionHandler.log(e);
            }
            while (entry != null) {
                if (entry.value.equals(value)) return entry.key;
                entry = entry.next;
            }
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        Entry entry = null;
        try {
            entry = getEntry(key);
        } catch (IOException | ClassNotFoundException e) {
            ExceptionHandler.log(e);
        }
        if (entry != null) return entry.value;
        return null;
    }

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }

}