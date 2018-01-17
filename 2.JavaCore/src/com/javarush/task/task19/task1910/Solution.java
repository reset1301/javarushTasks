package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
//        String s="c:\\111\\Сбер\\";
//        System.out.println(s.replaceAll("[\\W\\D]",""));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine(), out = br.readLine();
        br.close();
        br = new BufferedReader(new FileReader(in));
        BufferedWriter bw = new BufferedWriter(new FileWriter(out));
        while (br.ready()) {
            bw.write(br.readLine().replaceAll("[\\W]", ""));
        }
        br.close();
        bw.close();
    }
}
