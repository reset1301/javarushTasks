package com.javarush.task.task03.task0319;

/* 
Предсказание на будущее
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String s;
        int a,b;
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        s=r.readLine();
        a=Integer.parseInt(r.readLine());
        b=Integer.parseInt(r.readLine());
        System.out.println(s+" получает "+a+" через "+b+" лет.");
    }
}
