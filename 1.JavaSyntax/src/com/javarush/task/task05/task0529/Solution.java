package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int sum = 0 ;
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String s = r.readLine();
            if(!s.equals("сумма")){
                int num = Integer.parseInt(s);
                sum += num;
            }else{
                System.out.println(sum);
                break;
            }
        }
    }
}
