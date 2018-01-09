package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
//        System.out.println(String.format("%.0f",-3.5));
//        System.out.println(Math.round(3.51));
        FileInputStream f1 = new FileInputStream(s1);
        FileWriter f2 = new FileWriter(s2);
        String[] buf = (new BufferedReader(new FileReader(s1))).readLine().split(" ");
        for (int i = 0;i<buf.length;i++){
            double v = Double.parseDouble(buf[i]);
            f2.write(String.format("%d", Math.round(v))+" ");
        }
        f1.close();
        f2.close();
    }
}
