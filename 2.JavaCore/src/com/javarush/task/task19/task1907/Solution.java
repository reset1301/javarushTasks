package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
//        System.out.println("world".indexOf("wo"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();
        FileReader fileReader = new FileReader(fileName);
        StringBuilder s1 = new StringBuilder();
        while (fileReader.ready())
            s1.append((char) fileReader.read());
        fileReader.close();
        int count = 0;
        String[] mas=s1.toString().split("\\W");
//        s1 = new StringBuilder(s1.toString().toLowerCase());
//        while (s1.indexOf("world") != -1) {
//            s1 = new StringBuilder(s1.substring(s1.indexOf("world") + 2));
//            count++;
//        }
        for (String ss:mas
             ) {
            if (ss.toLowerCase().equals("world"))
                count++;
        }
        System.out.println(count);


    }
}
