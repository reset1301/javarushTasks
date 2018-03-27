package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;
    private static int x;

    public Producer(ConcurrentHashMap concurrentHashMap) {
        this.map = concurrentHashMap;
        x = 0;
    }

    @Override
    public void run() {
        try {
            while (true) {
                x++;
                map.put(x+"", String.format("Some text for %s", x));
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}
