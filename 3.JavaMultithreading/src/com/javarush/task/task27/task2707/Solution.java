package com.javarush.task.task27.task2707;

/*
Определяем порядок захвата монитора
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) throws InterruptedException {
        synchronized (obj1) {
            Thread.sleep(100);
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isNormalLockOrder(final Solution solution, final Object o1, final Object o2) throws Exception {
        //do something here
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o1) {
                    try {
                        Thread.sleep(500);
                        synchronized (o2) {
                            Thread.sleep(500);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    solution.someMethodWithSynchronizedBlocks(o1, o2);
                }
            }
        });
//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronized (o2) {
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    synchronized (o1) {
//                        try {
//                        solution.someMethodWithSynchronizedBlocks(o1, o2);
//
//                            Thread.sleep(1000);
//                        } catch (InterruptedException ignored) {
//                        }
//                    }
//                    }
//                }
//            }
//        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    solution.someMethodWithSynchronizedBlocks(o1, o2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        Thread.sleep(100);
        thread2.start();
        Thread.sleep(1000);
        System.out.println(thread1.getState());
        System.out.println(thread2.getState());
        return !thread2.getState().equals(Thread.State.BLOCKED);
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isNormalLockOrder(solution, o1, o2));
    }
}
