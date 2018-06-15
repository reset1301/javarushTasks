package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.RandomAccess;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) {
        String fileName = args[0], text = args[2];
        int number = Integer.parseInt(args[1]);
        try (RandomAccessFile file = new RandomAccessFile(fileName, "rw")) {
            if (file.length() < number) {
                file.seek(file.length());
            } else
                file.seek(number);
            file.write(text.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
