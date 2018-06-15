package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.TestOrder;

import java.io.IOException;
import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {
    List<Tablet> tablets;
    int interval;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
        this.tablets = tablets;
        this.interval = interval;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            Tablet tablet = tablets.get((int) ((tablets.size() - 1) * Math.random()));
            tablet.createTestOrder();
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                break;
//            e.printStackTrace();
            }
        }
    }
}
