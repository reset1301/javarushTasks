package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1=br.readLine();
        String s2=br.readLine();
        String s3 = br.readLine();
        FileOutputStream f1=new FileOutputStream(s1);
        FileInputStream f2 = new FileInputStream(s2);
        FileInputStream f3 = new FileInputStream(s3);
        while (f2.available()>0){
            f1.write(f2.read());
        }
        while (f3.available()>0){
            f1.write(f3.read());
        }
        f1.close();
        f2.close();
        f3.close();
    }
}
