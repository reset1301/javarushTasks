package com.javarush.task.task22.task2202;

//import com.javarush.task.task22.task2201.TooShortStringFirstThreadException;

import java.lang.reflect.Array;
import java.util.ArrayList;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("Амиго и Диего лучшиедрузья!"));
//        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        try {
            String s = "";
//        while (string.contains("  "))
//            string.replaceAll("  "," ");
            String[] s1 = string.split("[ ]+");
//        if (s1.length<5)
//            throw new TooShortStringException();
//        else
            s = s1[1] + " " + s1[2] + " " + s1[3] + " " + s1[4];
            return s;
        } catch (Exception e) {
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
