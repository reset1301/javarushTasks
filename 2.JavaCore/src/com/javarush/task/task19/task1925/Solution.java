package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1 = args[0], file2 = args[1];
        ArrayList<String> words = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file1));
        BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
        while (br.ready()) {
            String[] s = br.readLine().split(" ");
            for (String ss : s
                    ) {
                if (ss.length() > 6)
                    words.add(ss);
            }
        }
        br.close();
        for (int i = 0; i < words.size() - 1; i++)
            bw.write(words.get(i) + ",");
        bw.write(words.get(words.size() - 1));
        bw.close();

    }
}
