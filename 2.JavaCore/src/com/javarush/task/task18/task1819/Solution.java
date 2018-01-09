package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        FileInputStream f1 = new FileInputStream(s1);
        byte[] buf = new byte[f1.available()];
        f1.read(buf);
        f1.close();
        FileOutputStream f11=new FileOutputStream(s1);
        FileInputStream f2 = new FileInputStream(s2);
        while (f2.available()>0){
            f11.write(f2.read());
        }
        f11.write(buf);
        f2.close();
        f11.close();
    }
}
