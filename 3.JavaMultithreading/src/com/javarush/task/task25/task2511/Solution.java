package com.javarush.task.task25.task2511;

import java.util.TimerTask;

/* 
Вооружаемся до зубов!
*/
public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        this.handler = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                String name = t.getName();
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < name.length(); i++) {
                    stringBuilder.append("*");
                }
                t.setName(stringBuilder.toString());
                name = e.getMessage().replaceAll(name, stringBuilder.toString());
                System.out.println(name);
            }
        };
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
//        this.handler = null;    //init handler here
    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new TimerTask() {
            @Override
            public void run() {
                this.run();
            }
        });
        solution.run();
    }
}