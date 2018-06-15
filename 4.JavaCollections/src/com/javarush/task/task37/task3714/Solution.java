package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Древний Рим
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
//        String romanString = bufferedReader.readLine();
        String romanString = "MCMLXXXIX";
//        46	XLVI ; 583	DLXXXIII; 888	DCCCLXXXVIII; 1989	MCMLXXXIX
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        final String[] Rome = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
                "IX", "V", "IV", "I" };
        final int[] Arab = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

        StringBuffer romeNumber = new StringBuffer(s);
        int arabNumber = 0, i = 0;
// Проверяем переданную строку на наличие символов
        if (romeNumber.length() > 0) {
            while (true) {
                do {
                    if (Rome[i].length() <= romeNumber.length()) {
                        // Выделяем из строки подстроку и сравниваем со
                        // значением из массива Arab
                        if (Rome[i].equals(romeNumber.substring(0,
                                Rome[i].length()))) {
                            // После чего прибавляем число соответствующее
                            // индексу элемента римской цифры из массива Arab
                            arabNumber += Arab[i];
                            // и удаляем из строки римскую цифру
                            romeNumber.delete(0, Rome[i].length());
                            if (romeNumber.length() == 0)
                                return arabNumber;
                        } else
                            break;
                    } else
                        break;
                } while (true && romeNumber.length() != 0);
                i++;
            }
        }
        return 0;    }

}
