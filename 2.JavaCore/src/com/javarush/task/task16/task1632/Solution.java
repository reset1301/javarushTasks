package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    public static void main(String[] args) {

    }

    static {
        threads.add(0,new Thread1());
        threads.add(1,new Thread2());
        threads.add(2,new Thread3());
        threads.add(3,new Thread4());
        threads.add(4,new Thread5());

    }
    public static class Thread1 extends Thread {
        @Override
        public void run() {
            while (true) {
            }
        }
    }

    public static class Thread2 extends Thread {
        @Override
        public void run() {
//            while (!interrupted()){
            if (interrupted()) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class Thread3 extends Thread {
        @Override
        public void run() {
            while (!isInterrupted()) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Thread4 extends Thread implements Message {
        @Override
        public void run() {
            while (!isInterrupted()) {

            }
        }

        @Override
        public void showWarning() {
            this.interrupt();
        }
    }

    public static class Thread5 extends Thread {
        private int sum=0;

        @Override
        public void run() {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String s;
            try {
                while (!(s = bufferedReader.readLine()).equals("N")) {
                    int x=Integer.parseInt(s);
                    sum+=x;
                }
                System.out.println(sum);
            }catch (Exception e){}

        }
    }
}