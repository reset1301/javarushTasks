package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
//        System.out.println("1word".matches(Pattern. ([0 - 9])));
        String file1 = args[0], file2 = args[1];
        BufferedReader br = new BufferedReader(new FileReader(file1));
        BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
        Pattern p = Pattern.compile("[0-9]");
        while (br.ready()) {
            String[] s = br.readLine().split(" ");
            for (int i = 0; i < s.length; i++) {
                Matcher m = p.matcher(s[i]);
                if (m.find())
                    bw.write(s[i]+" ");
            }
        }
        br.close();
        bw.close();
    }
}
