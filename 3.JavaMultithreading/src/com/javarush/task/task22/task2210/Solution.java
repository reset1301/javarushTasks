package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        String[] s = getTokens("level22.lesson13.task01", ".");
        for (String ss:s
             ) {
            System.out.println(ss);
        }
        System.out.println();
    }

    public static String[] getTokens(String query, String delimiter) {
//        List<String>s=new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        String[] s = new String[tokenizer.countTokens()];
        int i = 0;
        while (tokenizer.hasMoreTokens()) {
            s[i] = tokenizer.nextToken();
            i++;
        }
        return s;
    }
}
