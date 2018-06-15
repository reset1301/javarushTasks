package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {
    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        Date start = new Date();
        for (String s : strings) {
            ids.add(shortener.getId(s));
        }
        return new Date().getTime() - start.getTime();
    }

    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        Date start = new Date();
        for (Long l : ids) {
            strings.add(shortener.getString(l));
        }
        return new Date().getTime() - start.getTime();
    }

    @Test
    public void testHashMapStorage() {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());


        Set<String> origStrings = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            origStrings.add(Helper.generateRandomString());
        }

        HashSet<Long> ids1 = new HashSet<>();
        Long t1 = getTimeForGettingIds(shortener1, origStrings, ids1);
        HashSet<Long> ids2 = new HashSet<>();
        Long t2 = getTimeForGettingIds(shortener2, origStrings, ids2);

        Assert.assertTrue(t1 > t2);

        t1 = getTimeForGettingStrings(shortener1, ids1, origStrings);
        t2 = getTimeForGettingStrings(shortener2, ids2, origStrings);

        Assert.assertEquals(t1, t2, 30);
    }
}
