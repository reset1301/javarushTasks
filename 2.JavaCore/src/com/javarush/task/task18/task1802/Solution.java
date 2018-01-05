package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());
        int minByte=65535;
        while (fileInputStream.available()>0){
            int x=fileInputStream.read();
            if (x<minByte)
                minByte=x;
        }
        System.out.println(minByte);
        fileInputStream.close();
    }
}
