package com.javarush.task.task19.task1914;

/* 
Решаем пример
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
        String s=arrayOutputStream.toString();
        String[]mas=s.split(" ");
        int res=0;
        if (mas[1].equals("+")){
            res=Integer.parseInt(mas[0])+Integer.parseInt(mas[2]);
        }
        else if (mas[1].equals("-")){
            res=Integer.parseInt(mas[0])-Integer.parseInt(mas[2]);
        }else if (mas[1].equals("*")){
            res=Integer.parseInt(mas[0])*Integer.parseInt(mas[2]);
        }
        System.out.println(mas[0]+" "+mas[1]+" "+mas[2]+" = "+res);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

