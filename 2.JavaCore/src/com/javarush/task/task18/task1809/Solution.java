package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        FileInputStream fileInputStream = new FileInputStream("c:\\111\\aaa.222");
        FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());
//        FileOutputStream fileOutputStream2 = new FileOutputStream("c:\\111\\2result.aaa");
        FileOutputStream fileOutputStream2 = new FileOutputStream(bufferedReader.readLine());
        byte[]buf=new byte[fileInputStream.available()];
        int count = fileInputStream.read(buf);
        for (int i=buf.length-1;i>=0;i--){
            fileOutputStream2.write(buf[i]);
        }
        fileInputStream.close();
        fileOutputStream2.close();
    }
}
