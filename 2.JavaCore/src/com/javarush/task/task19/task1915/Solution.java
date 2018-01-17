package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String file=br.readLine();
        br.close();
        PrintStream stream=System.out;
        ByteArrayOutputStream arrayOutputStream=new ByteArrayOutputStream();
        PrintStream stream1=new PrintStream(arrayOutputStream);
        System.setOut(stream1);
        testString.printSomething();
        System.setOut(stream);
        String s=arrayOutputStream.toString();
        System.out.println(s);
        FileOutputStream fileWriter=new FileOutputStream(file);
        fileWriter.write(s.getBytes());
        fileWriter.close();

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

