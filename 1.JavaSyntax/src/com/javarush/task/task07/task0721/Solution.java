package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum;
        int minimum;

        //напишите тут ваш код
        int[]a=new int[20];
        for (int i = 0; i < 20; i++) {
            a[i]=Integer.parseInt(reader.readLine());
        }
        maximum=a[0];
        minimum=a[0];
        for (int i = 1; i < 20; i++) {
            if(a[i]>maximum) maximum=a[i];
            if(a[i]<minimum) minimum=a[i];
        }

        System.out.println(maximum+" "+ minimum);
//        System.out.println(minimum);
    }
}
