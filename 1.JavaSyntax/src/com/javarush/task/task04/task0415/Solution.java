package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt(),b=sc.nextInt(),c=sc.nextInt();
        if(((a+b)>c)&&((a+c)>b)&&((b+c)>a))
            System.out.println("Треугольник существует.");
        else System.out.println("Треугольник не существует.");
    }
}