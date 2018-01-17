package com.javarush.task.task19.task1911;

/* 
Ридер обертка
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream stream = System.out;
        ByteArrayOutputStream byteArrayOutputStream =new ByteArrayOutputStream();
        PrintStream stream1=new PrintStream(byteArrayOutputStream);
        System.setOut(stream1);
        testString.printSomething();
        String res=byteArrayOutputStream.toString();
        System.setOut(stream);
        res=res.toUpperCase();
        System.out.println(res);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
