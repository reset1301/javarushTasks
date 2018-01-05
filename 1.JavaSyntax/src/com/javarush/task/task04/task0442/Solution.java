package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc=new Scanner(System.in);
        int i=0,summa=0;
        while(i!=-1){
            i=sc.nextInt();
            summa+=i;
        //    System.out.println(summa);
        }
        System.out.println(summa);
    }
}
