package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread thread;

    @Override
    public void run() {
//        System.out.println(this.thread.getName());
        try {
            while (!Thread.currentThread().isInterrupted()) { // Проверка на прерывание если interrupt() был вызван во время выполнения Thread.sleep(100), и завершается трэд.
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
//            e.printStackTrace();
        }
    }

    @Override
    public void start(String threadName) {
        this.thread = new Thread(this, threadName);
        this.thread.start();
    }

    @Override
    public void stop() {
        this.thread.interrupt();
    }
}
