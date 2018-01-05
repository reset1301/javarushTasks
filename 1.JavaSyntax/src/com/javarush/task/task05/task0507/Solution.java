package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc=new Scanner(System.in);
        double sum=1, x=0,count=0;
        while (x!=-1){
            x=sc.nextInt();
            sum+=x;
            count++;
        }
        count--;
        System.out.println(sum/count);

    }
}

