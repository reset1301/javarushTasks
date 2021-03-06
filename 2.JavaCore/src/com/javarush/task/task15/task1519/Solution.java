package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        while (!"exit".equals(s)){
//            System.out.println(s);
            try {
                if (s.contains("."))
                    print(Double.parseDouble(s));
                else if (Integer.parseInt(s)>0&&Integer.parseInt(s)<128)
                    print(Short.parseShort(s));
                else
                    print(Integer.parseInt(s));
            }
            catch (Exception e){
                print(s);
            }
            s=br.readLine();
        }

    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
