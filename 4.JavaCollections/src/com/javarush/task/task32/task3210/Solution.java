package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0], text = args[2];
        int number = Integer.parseInt(args[1]);
        byte[] b = new byte[text.length()];
        RandomAccessFile file = new RandomAccessFile(fileName, "rw");
        file.seek(number);
        file.read(b, 0, text.length());
        String s = new String(b, 0, text.length());
        file.seek(file.length());
        if (text.equals(s)) file.write("true".getBytes());
        else file.write("false".getBytes());
    }
}
