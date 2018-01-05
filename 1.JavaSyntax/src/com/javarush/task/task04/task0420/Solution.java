package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt(),b=sc.nextInt(),c=sc.nextInt(),d;
        if (a<b){
            d=a;
            a=b;
            b=d;
        }
        if (a<c){
            d=c;
            c=a;
            a=d;
        }
        if (b<c){
            d=c;
            c=b;
            b=d;
        }
        System.out.println(a+" "+b+" "+c);
    }
}
