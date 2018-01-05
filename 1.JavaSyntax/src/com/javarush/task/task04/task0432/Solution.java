package com.javarush.task.task04.task0432;



/* 
Хорошего много не бывает
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int N=sc.nextInt(),i=0;
        while (i<N) {
            System.out.println(s);
            i++;
        }
    }
}
