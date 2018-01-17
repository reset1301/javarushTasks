package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

import static java.lang.Character.isDigit;

public class Solution {
    public static void main(String[] args) throws IOException {
//        System.out.println(Integer.parseInt("8h"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine(), out = br.readLine();
        br.close();
        br = new BufferedReader(new FileReader(in));
        BufferedWriter bw = new BufferedWriter(new FileWriter(out));
        while (br.ready()) {
            String[] s = br.readLine().split(" ");
            for (String ss : s
                    ) {
//                try {
//                    int a =Integer.parseInt(ss);
//                    bw.write(a);
                boolean b = true;
                for (int i = 0; i < ss.length(); i++)
                    if (!isDigit(ss.charAt(i))) {
                        b = false;
                        break;
                    }
                if (b)
                    bw.write(ss + " ");
//                } catch (Exception e) {
//                }
            }
        }
        br.close();
        bw.close();
    }
}
