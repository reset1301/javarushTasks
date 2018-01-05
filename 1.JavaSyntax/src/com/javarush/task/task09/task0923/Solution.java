package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
Гласные и согласные
*/

public class Solution

{

    public static void main(String[] args) throws Exception

    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s = reader.readLine(); //читаем строку с консоли

        char [] charArray = s.toCharArray(); //создаем массив, куда поместим строку с консоли, и которую переводим в char



        ArrayList <Character> listCharVowels = new ArrayList <Character>(); //список для гласных

        ArrayList <Character> listCharNonVowels = new ArrayList <Character>(); //список для согласных



        for (int i=0; i < charArray.length; i++) //бежим по массиву

        {

            if (isVowel(charArray[i])) //проверяем условие методом isVowel если текуший символ гласная

            {

                listCharVowels.add(charArray[i]); //помещаем гласную в свой список

            }

            else if (charArray [i] == ' ')// проверяем есть ли пробел, и пропускаем его

            {

                continue;

            }

            else

            {

                listCharNonVowels.add(charArray[i]); //остальные буквы или другие символы(точка например), помещаем в свой список

            }

        }



        for (char c : listCharVowels)//бежим по списку, в который положили гласные

        {

            System.out.print(c + " "); //выводи гланые на экран, не забываем пробел между ними

        }



        System.out.println(); // переводим курсов на другую строчку



        for (char c : listCharNonVowels) //бежим по списку согласных

        {

            System.out.print(c + " "); //выводим на экран все остальные символы, через пробел

        }





    }





    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};



    //метод проверяет, гласная ли буква

    public static boolean isVowel(char c)

    {

        c = Character.toLowerCase(c);  //приводим символ в нижний регистр - от заглавных к строчным буквам



        for (char d : vowels)   //ищем среди массива гласных

        {

            if (c == d)

                return true;

        }

        return false;

    }

}