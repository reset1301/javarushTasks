package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt(),b=sc.nextInt(),c=sc.nextInt(),d=sc.nextInt();
        if((a>=b)&&(a>=c)&&(a>=d)) System.out.println(a);
        else if((b>=a)&&(b>=c)&&(b>=d)) System.out.println(b);
        else if((c>=b)&&(c>=a)&&(a>=d)) System.out.println(c);
        else System.out.println(d);
    }
}
