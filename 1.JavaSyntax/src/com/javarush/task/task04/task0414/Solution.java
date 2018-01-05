package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        if((x%4!=0)||((x%4==0)&&(x%100==0)&&(x%400!=0)))
            System.out.println("количество дней в году: "+365);
        else System.out.println("количество дней в году: "+366);

    }
}