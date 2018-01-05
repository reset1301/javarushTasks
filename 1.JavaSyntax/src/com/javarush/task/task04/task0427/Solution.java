package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        if      ((a>0)&&(a/10<1)&&(a%2==0)&&(a<1000)) System.out.println("четное однозначное число");
        else if ((a>0)&&(a<1000)&&(a/10<1)&&(a%2!=0)) System.out.println("нечетное однозначное число");
        else if ((a>0)&&(a<1000)&&(a/100<1)&&(a%2==0)) System.out.println("четное двузначное число");
        else if ((a>0)&&(a<1000)&&(a/100<1)&&(a%2!=0)) System.out.println("нечетное двузначное число");
        else if ((a>0)&&(a<1000)&&(a/1000<1)&&(a%2==0)) System.out.println("четное трехзначное число");
        else if ((a>0)&&(a<1000)&&(a/1000<1)&&(a%2!=0)) System.out.println("нечетное трехзначное число");


    }
}
