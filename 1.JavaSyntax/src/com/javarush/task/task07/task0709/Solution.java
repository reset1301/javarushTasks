package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList <String >l=new ArrayList<>();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            l.add(br.readLine());
        }
        int min=l.get(0).length();
        for (int i = 1; i < l.size(); i++) {
            if(min>l.get(i).length())
                min=l.get(i).length();
        }
        for (int i = 0; i < l.size(); i++) {
            if(l.get(i).length()==min)
                System.out.println(l.get(i));
        }
    }

}

