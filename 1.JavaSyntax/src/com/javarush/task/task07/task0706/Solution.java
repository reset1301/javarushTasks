package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int sum1=0,sum2=0;
        int[]a=new int[15];
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 15; i++) {
            a[i]=Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < 15; i++) {
            if(i%2==0)
                sum2+=a[i];
            else sum1+=a[i];
        }
        if(sum1>sum2)
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        else
            System.out.println("В домах с четными номерами проживает больше жителей.");
    }
}
