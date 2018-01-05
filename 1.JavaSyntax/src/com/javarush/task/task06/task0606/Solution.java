package com.javarush.task.task06.task0606;

import java.io.*;
import java.util.Scanner;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even=0;
    public static int odd=0;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        while (x>0){
            int a=x%10;
            x/=10;
            if(a%2==0)
                even++;
            else
                odd++;
        }
        System.out.println("Even: " +
                even+
                " Odd: " +
                odd);
    }
}
