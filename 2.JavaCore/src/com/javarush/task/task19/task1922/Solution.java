package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = br.readLine();
        br.close();
        br = new BufferedReader(new FileReader(nameFile));
        while (br.ready()) {
            String ss = br.readLine();
            String[] s =ss.split(" ");
            int count = 0;
            for (int i = 0; i < s.length; i++) {
                for (int j = 0; j < words.size(); j++) {
                    if (s[i].equals(words.get(j)))
                        count++;
                }
            }
            if (count==2)
                System.out.println(ss);
        }
        br.close();
    }
}
