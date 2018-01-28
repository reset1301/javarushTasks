package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
//        char[] s = "я - программист.".toCharArray();
//        System.out.println(s);
//        for (int i = 0; i < s.length / 2; i++) {
//            char buf = s[i];
//            s[i] = s[s.length - 1 - i];
//            s[s.length - 1 - i] = buf;
//        }
//        for (char c : s)
//            System.out.print(c);


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = br.readLine();
        br.close();
        br = new BufferedReader(new FileReader(nameFile));
        while (br.ready()) {
            char[] s = br.readLine().toCharArray();
            for (int i = 0; i < s.length / 2; i++) {
                char buf = s[i];
                s[i] = s[s.length - 1 - i];
                s[s.length - 1 - i] = buf;
            }
            for (char c : s)
                System.out.print(c);
            System.out.println();
        }
        br.close();
    }
}
