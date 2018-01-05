package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());
//        FileInputStream fileInputStream = new FileInputStream("c:\\111\\aaa.222");
//        System.out.println((byte)',');
        byte[] buf=new byte[fileInputStream.available()];
        int sum=0;
        while (fileInputStream.available()>0){
            int count = fileInputStream.read(buf);
            for (int i=0;i<count;i++){
                if (buf[i]==44)
                    sum++;
            }
        }
        System.out.println(sum);
        fileInputStream.close();
    }
}
