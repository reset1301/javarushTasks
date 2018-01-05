package com.javarush.task.task16.task1623;

/* 
Рекурсивное создание нитей
*/

public class Solution {
    static int count = 15;
    static volatile int countCreatedThreads=0;

    public static void main(String[] args) {
//        while (countCreatedThreads<count) {
            System.out.println(new GenerateThread());
//            countCreatedThreads++;
//        }
    }

    public static class GenerateThread extends Thread{
        public GenerateThread() {
            super(String.valueOf(++countCreatedThreads));
//            countCreatedThreads++;
            this.start();
        }

        @Override
        public void run() {
            if (Solution.count>countCreatedThreads){
                GenerateThread generateThread = new GenerateThread();
                System.out.println(generateThread);
            }
        }

        @Override
        public String toString() {
            return this.getName()+" created";
        }
    }
}
