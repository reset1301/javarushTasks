package com.javarush.task.task04.task0421;

/* 
Настя или Настя?
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s1=br.readLine(),s2=br.readLine();
        if (s1.equals(s2)) System.out.println("Имена идентичны");
        else if (!s1.equals(s2)&&s1.length()==s2.length()) System.out.println("Длины имен равны");
    }
}