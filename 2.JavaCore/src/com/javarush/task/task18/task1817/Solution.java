package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int total=fileInputStream.available(),count = 0;
        while (fileInputStream.available()>0){
            char c = (char) fileInputStream.read();
            if (c==' ')
                count++;
        }
        System.out.println(String.format(Locale.ENGLISH,"%.2f", (double)(count*100.0)/total));
        fileInputStream.close();
    }
}
