package com.javarush.task.task22.task2211;

import java.io.*;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String w1251 = args[0], utf8 = args[1];
        FileInputStream fr = new FileInputStream(w1251);
        byte[] bytes = new byte[1000];
        FileOutputStream fw = new FileOutputStream(utf8);
        while (fr.available()>0) {
            fr.read(bytes);
            String s = new String(bytes, "Windows-1251");
            fw.write(s.getBytes("UTF-8"));
        }
        fr.close();
        fw.close();
    }
}
