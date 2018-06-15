package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        File file1 = new File(args[0]);
        BufferedReader br = new BufferedReader(new FileReader(file1));
        StringBuilder sb = new StringBuilder();
        while (br.ready())
            sb.append(br.readLine());
//        System.out.println(sb.toString());

        TreeSet<Character> treeSet = new TreeSet<>();
        for (int i = 0; i < sb.length(); i++) {
            if (Character.isAlphabetic(sb.charAt(i)))
                treeSet.add(Character.toLowerCase(sb.charAt(i)));
        }
        int size = treeSet.size()>5?5: treeSet.size();
        for (int i = 0; i < size; i++) {
            System.out.print(treeSet.pollFirst());
        }
    }
}
