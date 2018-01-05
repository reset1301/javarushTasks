package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        ArrayList<Integer>count=new ArrayList<>();
        for (int i = 0; i < 33; i++) {
            count.add(0);
        }
//        String s1 = new String();
        int ii=0;
        // напишите тут ваш код
        for (String s:list             ) {
//            s1=s;

//            System.out.println(s1);
            ii=0;
            for (Character ch:alphabet) {
                for (int j = 0; j < s.length(); j++) {
                    char buf=s.charAt(j);
                    if(ch.equals(buf))
                        count.set(ii,count.get(ii)+1);
                }
//                System.out.println(ch);
                ii++;
            }
        }

        for (int j = 0; j < 33; j++) {
            System.out.println(alphabet.get(j)+" "+count.get(j));
        }
    }

}
