package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[]a=new int[20],b=new int[10],c=new int[10];
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 20; i++) {
            a[i]=Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < 10; i++) {
            b[i]=a[i];
            c[i]=a[i+10];
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(c[i]);
        }
    }
}
