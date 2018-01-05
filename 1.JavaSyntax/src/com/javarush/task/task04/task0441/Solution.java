package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/
import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] mas=new int[3];
        Scanner sc=new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            mas[i]=sc.nextInt();
        }
        for (int i = 0; i < 2; i++) {
            for (int j = i+1; j < 3; j++) {
                if(mas[i]<mas[j]){
                    int buf=mas[i];
                    mas[i]=mas[j];
                    mas[j]=buf;
                }
            }

        }
        System.out.println(mas[1]);
            }
}
