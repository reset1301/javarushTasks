package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream printStream=System.out;
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream1 = new PrintStream(arrayOutputStream);
        System.setOut(printStream1);
        testString.printSomething();
        System.setOut(printStream);
        String[] s = arrayOutputStream.toString().split(System.lineSeparator());
        for (int i=0;i<s.length;i+=2) {
            System.out.println(s[i]);
            if (i<s.length-1){
                System.out.println(s[i+1]);
                System.out.println("JavaRush - курсы Java онлайн");
            }
        }

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
