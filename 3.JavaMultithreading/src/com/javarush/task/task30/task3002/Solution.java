package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        //напишите тут ваш код
        StringBuilder sb = new StringBuilder(s);
        int result;
        if (s.charAt(0)=='0'&&s.charAt(1)=='x')
            result = Integer.parseInt(s.substring(2), 16);
        else if (s.charAt(0)=='0'&&s.charAt(1)=='b')
            result = Integer.parseInt(s.substring(2), 2);
        else if (s.charAt(0)=='0')
            result = Integer.parseInt(s, 8);
        else result = Integer.parseInt(s);
        return result+"";
    }
}
