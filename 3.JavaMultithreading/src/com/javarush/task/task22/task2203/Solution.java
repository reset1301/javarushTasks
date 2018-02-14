package com.javarush.task.task22.task2203;

/*
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        try {
            String s = string.substring(string.indexOf("\t")+1);
            return s.substring(0,s.indexOf("\t"));
        }catch (Exception e){
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
        String s = "\tJavaRush - лучший сервис \tобучения Java\t.";
//        System.out.println(s.indexOf("\t"));
//        String s1 = s.substring(s.indexOf("\t") + 1);
//        System.out.println(s1);
//        System.out.println(s1.substring(0,s1.indexOf("\t")));
    }
}
