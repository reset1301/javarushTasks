package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread loggingStateThread;
    private State state;

    public LoggingStateThread(Thread loggingStateThread) {
        this.loggingStateThread = loggingStateThread;
        this.state = loggingStateThread.getState();
//        this.setDaemon(true);
    }

    @Override
    public void run() {
        System.out.println(state);
        while (true) {
            if (this.loggingStateThread.getState() != state) {
                state = this.loggingStateThread.getState();
                System.out.println(state);
            }
            if (state == State.TERMINATED)
                break;
        }
    }
}
