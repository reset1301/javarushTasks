package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
//        System.out.println(new BigInteger(130, new SecureRandom()).toString(36));
//        System.out.println(new Date().getTime());
        HashMapStorageStrategy hashMapStorageStrategy = new HashMapStorageStrategy();
        testStrategy(hashMapStorageStrategy, 10000);
        Helper.printMessage("--------------");
        OurHashMapStorageStrategy ourHashMapStorageStrategy = new OurHashMapStorageStrategy();
        testStrategy(ourHashMapStorageStrategy, 10000);
        Helper.printMessage("--------------");
        FileStorageStrategy fileStorageStrategy = new FileStorageStrategy();
        testStrategy(fileStorageStrategy, 100);
        Helper.printMessage("--------------");
        OurHashBiMapStorageStrategy ourHashBiMapStorageStrategy = new OurHashBiMapStorageStrategy();
        testStrategy(ourHashBiMapStorageStrategy, 10000);
        Helper.printMessage("--------------");
        HashBiMapStorageStrategy hashBiMapStorageStrategy = new HashBiMapStorageStrategy();
        testStrategy(hashBiMapStorageStrategy,10000);
        Helper.printMessage("--------------");
        DualHashBidiMapStorageStrategy dualHashBidiMapStorageStrategy = new DualHashBidiMapStorageStrategy();
        testStrategy(dualHashBidiMapStorageStrategy,10000);
        Helper.printMessage("--------------");

    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> set = new HashSet<>();
        for (String s : strings) {
            set.add(shortener.getId(s));
        }
        return set;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> set = new HashSet<>();
        for (Long l : keys) {
            set.add(shortener.getString(l));
        }
        return set;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            set.add(Helper.generateRandomString());
        }

        Shortener shortener = new Shortener(strategy);

        Date start = new Date();
        Set<Long> longSet = getIds(shortener, set);
        Helper.printMessage("Method getIds worked for: " + (new Date().getTime() - start.getTime()));

        start = new Date();
        Set<String> stringSet = getStrings(shortener, longSet);
        Helper.printMessage("Method getStrings worked for: " + (new Date().getTime() - start.getTime()));

        boolean flag = true;
        for (String s : set) {
            flag = false;
            for (String s1 : stringSet) {
                if (s.equals(s1)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                Helper.printMessage("Тест не пройден.");
                break;
            }
        }
        if (flag)
            Helper.printMessage("Тест пройден.");
    }
}
