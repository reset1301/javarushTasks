package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String>s=new ArrayList<>();
        s.add("мама");
        s.add("мыла");
        s.add("раму");
        for (int i = 2; i >=0 ; i--) {
            s.add(i+1,"именно");
        }
        for (int i = 0; i < s.size(); i++) {
            System.out.println(s.get(i));
        }
    }
}
