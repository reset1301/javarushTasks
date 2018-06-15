package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Consumer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(450);
            } catch (InterruptedException e) {
//                e.printStackTrace();
                break;
            }
            while (!queue.isEmpty()) {
                try {
                    System.out.format("Processing " + queue.take().toString() + System.lineSeparator());
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
}
