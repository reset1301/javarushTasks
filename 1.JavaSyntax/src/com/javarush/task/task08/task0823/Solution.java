package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Character.*;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        //напишите тут ваш код
        char[] ch=new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            ch[i]=s.charAt(i);
        }
        for (int i = 0; i < s.length()-1; i++) {
            if((isWhitespace(ch[i]))&&(isLetter(ch[i+1]))) ch[i+1]=toUpperCase(ch[i+1]);
            if(isLowerCase(ch[0])) ch[0]=toUpperCase(ch[0]);
        }
        for (int i = 0; i < ch.length; i++) {
            System.out.print(ch[i]);
        }
    }
}
