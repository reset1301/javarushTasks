package com.javarush.task.task22.task2212;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null || telNumber == "")
            return false;
        int countDigit = countDigit(telNumber);
        int countMinus = countMinus(telNumber);
        if (!isLastDigit(telNumber))
            return false;
        if (countMinus > 2)
            return false;
        if (!isBrackets(telNumber))
            return false;
        if (!isDigit(telNumber))
            return false;
        if (isPlus(telNumber)) {
            if (countDigit != 12)
                return false;
        } else {
            if (countDigit != 10)
                return false;

        }

        return true;
    }

    private static int countDigit(String telNumber) {
        int count = 0;
        Pattern p = Pattern.compile("[0-9]");
        Matcher m = p.matcher(telNumber);
        while (m.find())
            count++;
//        System.out.println("countDigit" + count);
        return count;
    }

    private static boolean isPlus(String telNumber) {
        StringBuilder s = new StringBuilder(telNumber);
        if (telNumber.lastIndexOf('+') != 0 && telNumber.lastIndexOf('+') != -1)
            return false;
        if (s.charAt(0) == '+')
            return true;
        return false;
    }

    private static int countMinus(String telNumber) {
        int count = 0;
        StringBuilder s = new StringBuilder(telNumber);
        for (int i = 0; i < s.length() - 1; i++)
            if (s.charAt(i) == '-' && s.charAt(i + 1) == '-')
                return 10;
        Pattern p = Pattern.compile("-");
        Matcher m = p.matcher(telNumber);
        while (m.find())
            count++;
//        System.out.println("countMinus " + count);
        return count;
    }

    private static boolean isBrackets(String telNumber) {
        StringBuilder s = new StringBuilder(telNumber);
//        int start=10000,end=0,minus=100000;
//        boolean st=false,en=false,mi=false;
//        int ind = s.indexOf("("), last = s.lastIndexOf("(");
//        System.out.print("Mezdu ( i ) ");
//        System.out.println(s.indexOf(")")-s.indexOf("("));
        if (s.lastIndexOf("(") != s.indexOf("("))
            return false;
        if (s.lastIndexOf(")") != s.indexOf(")"))
            return false;
        if (s.indexOf("(") >= 0 && s.indexOf("(") > s.indexOf(")"))
            return false;
        if (s.indexOf("(") >= 0 && s.indexOf("-") >= 0 && s.indexOf(")") > s.indexOf("-"))
            return false;
//        for (int i=0;i<s.length();i++) {
//            s.
//        }
        if (s.indexOf("(") >= 0)
            return isThree(telNumber);
        return true;
    }

    private static boolean isThree(String telNumber) {
        if (telNumber.indexOf(")") - telNumber.indexOf("(") == 4)
            return true;
        return false;
    }

    private static boolean isLastDigit(String telNumber) {
//        System.out.println(telNumber.charAt(telNumber.length() - 1));
        return (telNumber.charAt(telNumber.length() - 1) == '0')
                || (telNumber.charAt(telNumber.length() - 1) == '1')
                || (telNumber.charAt(telNumber.length() - 1) == '2')
                || (telNumber.charAt(telNumber.length() - 1) == '3')
                || (telNumber.charAt(telNumber.length() - 1) == '4')
                || (telNumber.charAt(telNumber.length() - 1) == '5')
                || (telNumber.charAt(telNumber.length() - 1) == '6')
                || (telNumber.charAt(telNumber.length() - 1) == '7')
                || (telNumber.charAt(telNumber.length() - 1) == '8')
                || (telNumber.charAt(telNumber.length() - 1) == '9');
    }

    private static boolean isDigit(String telNumber) {
        for (int i = 0; i < telNumber.length(); i++) {
            if ((telNumber.charAt(i) != '0')
                    && (telNumber.charAt(i) != '1')
                    && (telNumber.charAt(i) != '2')
                    && (telNumber.charAt(i) != '3')
                    && (telNumber.charAt(i) != '4')
                    && (telNumber.charAt(i) != '5')
                    && (telNumber.charAt(i) != '6')
                    && (telNumber.charAt(i) != '7')
                    && (telNumber.charAt(i) != '8')
                    && (telNumber.charAt(i) != '9')
                    && (telNumber.charAt(i) != '+')
                    && (telNumber.charAt(i) != '-')
                    && (telNumber.charAt(i) != '(')
                    && (telNumber.charAt(i) != ')'))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("+38((050)1-23-45-6-7 " + checkTelNumber("+38((050)1-23-45-6-7"));
        System.out.println("+380501234567 " + checkTelNumber("+380501234567"));
        System.out.println("+3805+01234567 " + checkTelNumber("+3805+01234567"));
        System.out.println("+38(050)1234567 " + checkTelNumber("+38(050)1234567"));
        System.out.println("+38050123-45-67 " + checkTelNumber("+38050123-45-67"));
        System.out.println("050123-4567 " + checkTelNumber("050123-4567"));
        System.out.println("+38)050(1234567 " + checkTelNumber("+38)050(1234567"));
        System.out.println("+38(050)1-23-45-6-7 " + checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println("050ххх4567 " + checkTelNumber("050ххх4567"));
        System.out.println("050000ххх4567 " + checkTelNumber("050000ххх4567"));
        System.out.println("050123456 " + checkTelNumber("050123456"));
        System.out.println("(0)501234567 " + checkTelNumber("(0)501234567"));
        System.out.println("(0)501234--567 " + checkTelNumber("(0)501234--567"));
//        System.out.println("matches "+"050ххх4567".matches("[0-9]"));
        Pattern p = Pattern.compile("\\D");
        Matcher m = p.matcher("050ххх4567");
        if (m.find())
            System.out.println("matches = true");
    }
}
