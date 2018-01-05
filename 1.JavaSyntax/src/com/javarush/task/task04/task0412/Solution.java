package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner r=new Scanner(System.in);
        int x=r.nextInt();
        if (x>0)
            System.out.println(x*2);
        else if (x<0)
            System.out.println(x+1);
        else System.out.println(x);


    }

}