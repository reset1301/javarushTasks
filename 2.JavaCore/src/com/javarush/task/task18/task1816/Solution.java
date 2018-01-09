package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        char c;
        String s1="abcdefghijklmnopqrstuvwxyz",
        s2=s1.toUpperCase();
        int count=0;
        while (fileInputStream.available()>0){
            c= (char) fileInputStream.read();
            if (s1.indexOf(c)!=-1||s2.indexOf(c)!=-1)
                count++;
        }
        System.out.println(count);
        fileInputStream.close();
    }
}
