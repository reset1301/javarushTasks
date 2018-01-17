package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream stream=System.out;
        ByteArrayOutputStream arrayOutputStream=new ByteArrayOutputStream();
        PrintStream stream1=new PrintStream(arrayOutputStream);
        System.setOut(stream1);
        testString.printSomething();
        System.setOut(stream);
        String s=arrayOutputStream.toString().replaceAll("te","??");
        System.out.println(s);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
