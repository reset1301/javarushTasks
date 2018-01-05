package com.javarush.task.task07.task0710;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
В начало списка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        //---------------
        ArrayList <String>l=new ArrayList<>();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            String s=new String();
            s=br.readLine();
            l.add(0,s);
        }
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }

    //---------------
    }
}
