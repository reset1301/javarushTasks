package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
//            FileInputStream fileInputStream = new FileInputStream("c:\\111\\aaa.222");
            FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());
//            FileOutputStream fileOutputStream2 = new FileOutputStream("c:\\111\\2result.aaa");
//            FileOutputStream fileOutputStream2 = new FileOutputStream(bufferedReader.readLine());
            int size = fileInputStream.available();
            fileInputStream.close();
            if (size < 1000) {
//                fileInputStream.close();
//                fileOutputStream2.close();
                throw new DownloadException();
            }
        }
    }

    public static class DownloadException extends Exception {

    }
}
