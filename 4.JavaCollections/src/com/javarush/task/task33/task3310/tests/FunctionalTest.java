package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

public class FunctionalTest {
    public void testStorage(Shortener shortener) {
        String s1 = Helper.generateRandomString();
        String s2 = Helper.generateRandomString();
        String s3 = s1;

        Long id1 = shortener.getId(s1);
        Long id2 = shortener.getId(s2);
        Long id3 = shortener.getId(s3);

        Assert.assertNotEquals(id1, id2);
        Assert.assertNotEquals(id3, id2);
        Assert.assertEquals(id1, id3);

        String ss1 = shortener.getString(id1);
        String ss2 = shortener.getString(id2);
        String ss3 = shortener.getString(id3);

        Assert.assertEquals(s1, ss1);
        Assert.assertEquals(s2, ss2);
        Assert.assertEquals(s3, ss3);
    }

    @Test(timeout = 100, expected = NullPointerException.class)
    public void testHashMapStorageStrategy() {
        HashMapStorageStrategy hashMapStorageStrategy = new HashMapStorageStrategy();
        Shortener shortener = new Shortener(hashMapStorageStrategy);
        testStorage(shortener);
        throw new NullPointerException();
    }

    @Test
    @Ignore
    public void testOurHashMapStorageStrategy() {
        OurHashMapStorageStrategy hashMapStorageStrategy = new OurHashMapStorageStrategy();
        Shortener shortener = new Shortener(hashMapStorageStrategy);
        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy() throws IOException {
        FileStorageStrategy hashMapStorageStrategy = new FileStorageStrategy();
        Shortener shortener = new Shortener(hashMapStorageStrategy);
        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy() {
        HashBiMapStorageStrategy hashMapStorageStrategy = new HashBiMapStorageStrategy();
        Shortener shortener = new Shortener(hashMapStorageStrategy);
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy() {
        DualHashBidiMapStorageStrategy hashMapStorageStrategy = new DualHashBidiMapStorageStrategy();
        Shortener shortener = new Shortener(hashMapStorageStrategy);
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy() {
        OurHashBiMapStorageStrategy hashMapStorageStrategy = new OurHashBiMapStorageStrategy();
        Shortener shortener = new Shortener(hashMapStorageStrategy);
        testStorage(shortener);
    }
}
