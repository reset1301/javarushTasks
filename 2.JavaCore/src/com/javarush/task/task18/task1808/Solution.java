package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());
//        FileOutputStream fileOutputStream2 = new FileOutputStream("c:\\111\\2result.aaa");
        FileOutputStream fileOutputStream2 = new FileOutputStream(bufferedReader.readLine());
//        FileOutputStream fileOutputStream3 = new FileOutputStream("c:\\111\\3result.aaa");
        FileOutputStream fileOutputStream3 = new FileOutputStream(bufferedReader.readLine());
//        FileInputStream fileInputStream = new FileInputStream("c:\\111\\aaa.222");

        if (fileInputStream.available()%2==1) {
            byte[]buf=new byte[fileInputStream.available()/2+1];
            int count = fileInputStream.read(buf);
            fileOutputStream2.write(buf);
            byte[]buf1=new byte[count-1];
            count = fileInputStream.read(buf1);
            fileOutputStream3.write(buf1);
        }
        else {
            byte[]buf=new byte[fileInputStream.available()/2];
            int count = fileInputStream.read(buf);
            fileOutputStream2.write(buf);
            byte[]buf1=new byte[count];
            count = fileInputStream.read(buf1);
            fileOutputStream3.write(buf1);
        }
        fileInputStream.close();
        fileOutputStream2.close();
        fileOutputStream3.close();
    }
}
