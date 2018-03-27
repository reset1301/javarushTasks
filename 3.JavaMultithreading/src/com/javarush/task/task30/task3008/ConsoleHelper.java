package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
//        boolean b = true;
        String s="";
        while (true) {
            try {
                 s=reader.readLine();
                 break;
            } catch (IOException e) {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }
        return s;
    }

    public static int readInt() {
//        String s = "";
        int x=0;
        while (true) {
            try {
                x = Integer.parseInt(readString());
                break;
            } catch (NumberFormatException nfe) {
                System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        }
        return x;
    }

}
