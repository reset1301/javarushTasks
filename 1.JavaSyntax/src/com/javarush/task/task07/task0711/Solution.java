package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String>l=new ArrayList<>();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            l.add(br.readLine());
        }
        for (int i = 0; i < 13; i++) {
            String s=l.get(l.size()-1);
            l.remove(l.size()-1);
            l.add(0,s);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(l.get(i));
        }
    }
}
