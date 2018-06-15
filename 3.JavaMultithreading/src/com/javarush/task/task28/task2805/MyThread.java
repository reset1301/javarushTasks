package com.javarush.task.task28.task2805;

public class MyThread extends Thread {
    static int priority = 0;

    public MyThread() {
        setPrior();
    }

    public MyThread(Runnable target) {
        super(target);
        setPrior();

    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        setPrior();
    }

    public MyThread(String name) {
        super(name);
        setPrior();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        setPrior();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setPrior();
    }

    private void setPrior() {
        priority++;
        if (priority == 11)
            priority = 1;
        this.setPriority(priority);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        setPrior();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        setPrior();
    }

//    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize, boolean inheritThreadLocals) {
//        super(group, target, name, stackSize, inheritThreadLocals);
//        setPrior();
//    }
}
