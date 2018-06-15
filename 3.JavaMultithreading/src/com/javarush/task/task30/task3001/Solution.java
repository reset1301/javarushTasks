package com.javarush.task.task30.task3001;

import java.math.BigInteger;

import static com.javarush.task.task30.task3001.NumerationSystemType.*;

/*
Конвертер систем счислений
*/
public class Solution {
    public static void main(String[] args) {
        Number number = new Number(_10, "6");
        Number result = convertNumberToOtherNumerationSystem(number, _2);
        System.out.println(result);    //expected 110

        number = new Number(_16, "6df");
        result = convertNumberToOtherNumerationSystem(number, NumerationSystemType._8);
        System.out.println(result);    //expected 3337
    }

    public static Number convertNumberToOtherNumerationSystem(Number number, NumerationSystem expectedNumerationSystem) {
        //напишите тут ваш код
////        System.out.println(isCorrectSystem(number));
//        if (!isCorrectSystem(number))
//            throw new NumberFormatException();
//        int expNumerationSystem = expectedNumerationSystem.getNumerationSystemIntValue();
//        int num10 = num10(number);
//        int b;
//        StringBuilder sb = new StringBuilder();
//        while (num10 != 0) {
//            b = num10 % expNumerationSystem;
////            System.out.print(b);
//            sb.append(b);
//            num10 = num10 / expNumerationSystem;
//        }
////        System.out.println(sb.reverse().toString());
//        return new Number(expectedNumerationSystem,sb.reverse().toString());
        BigInteger bi = new BigInteger(number.getDigit(), number.getNumerationSystem().getNumerationSystemIntValue());
        String ans = bi.toString(expectedNumerationSystem.getNumerationSystemIntValue());

        return new Number(expectedNumerationSystem, ans);

    }

    public static int num10(Number number) {
//        int result = 0;
//        int numSys;
//        int pos;
//        StringBuilder num = new StringBuilder(number.getDigit().toLowerCase());
        if (NumerationSystemType._2.equals(number.getNumerationSystem())) {
//            numSys = 2;
//            for (int i = 0; i < num.length(); i++) {
//                pos = 1;
//                char c = num.charAt(i);
//                for (int j = 0; j < num.length() - 1 - i; j++) {
//                    pos *= numSys;
//                }
//                if (c == '1') {
//                    result += pos * 1;
//                }
//            }
//            return result;
            return Integer.parseInt(number.getDigit(), 2);

        }
        if (NumerationSystemType._3.equals(number.getNumerationSystem())) {
            return Integer.parseInt(number.getDigit(), 3);
        }
        if (NumerationSystemType._4.equals(number.getNumerationSystem())) {
            return Integer.parseInt(number.getDigit(), 4);
        }
        if (NumerationSystemType._5.equals(number.getNumerationSystem())) {
            return Integer.parseInt(number.getDigit(), 5);
        }
        if (NumerationSystemType._6.equals(number.getNumerationSystem())) {
            return Integer.parseInt(number.getDigit(), 6);
        }
        if (NumerationSystemType._7.equals(number.getNumerationSystem())) {
            return Integer.parseInt(number.getDigit(), 7);
        }
        if (NumerationSystemType._8.equals(number.getNumerationSystem())) {
            return Integer.parseInt(number.getDigit(), 8);
        }
        if (NumerationSystemType._9.equals(number.getNumerationSystem())) {
            return Integer.parseInt(number.getDigit(), 9);
        }
        if (NumerationSystemType._10.equals(number.getNumerationSystem())) {
            return Integer.parseInt(number.getDigit());
        }
        if (NumerationSystemType._12.equals(number.getNumerationSystem())) {
            return Integer.parseInt(number.getDigit(), 12);
        }
        if (NumerationSystemType._16.equals(number.getNumerationSystem())) {
            return Integer.parseInt(number.getDigit(),16);
        }
        return 0;
    }

    public static boolean isCorrectSystem(Number number) {
        NumerationSystem[] numerationSystems = NumerationSystemType.values();
//        boolean isCorrectSystem = true;
        StringBuilder num = new StringBuilder(number.getDigit().toLowerCase());
        if (NumerationSystemType._2.equals(number.getNumerationSystem())) {
            for (int i = 0; i < num.length(); i++) {
                char c = num.charAt(i);
                if (c != '0' && c != '1')
                    return false;
            }
        }
        if (NumerationSystemType._3.equals(number.getNumerationSystem())) {
            for (int i = 0; i < num.length(); i++) {
                char c = num.charAt(i);
                if (c != '0' && c != '1' && c != '2')
                    return false;
            }
        }
        if (NumerationSystemType._4.equals(number.getNumerationSystem())) {
            for (int i = 0; i < num.length(); i++) {
                char c = num.charAt(i);
                if (c != '0' && c != '1' && c != '2' && c != '3')
                    return false;
            }
        }
        if (NumerationSystemType._5.equals(number.getNumerationSystem())) {
            for (int i = 0; i < num.length(); i++) {
                char c = num.charAt(i);
                if (c != '0' && c != '1' && c != '2' && c != '3' && c != '4')
                    return false;
            }
        }
        if (NumerationSystemType._6.equals(number.getNumerationSystem())) {
            for (int i = 0; i < num.length(); i++) {
                char c = num.charAt(i);
                if (c != '0' && c != '1' && c != '2' && c != '3' && c != '4' && c != '5')
                    return false;
            }
        }
        if (NumerationSystemType._7.equals(number.getNumerationSystem())) {
            for (int i = 0; i < num.length(); i++) {
                char c = num.charAt(i);
                if (c != '0' && c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6')
                    return false;
            }
        }
        if (NumerationSystemType._8.equals(number.getNumerationSystem())) {
            for (int i = 0; i < num.length(); i++) {
                char c = num.charAt(i);
                if (c != '0' && c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6' && c != '7')
                    return false;
            }
        }
        if (NumerationSystemType._9.equals(number.getNumerationSystem())) {
            for (int i = 0; i < num.length(); i++) {
                char c = num.charAt(i);
                if (c != '0' && c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6' && c != '7' && c != '8')
                    return false;
            }
        }
        if (NumerationSystemType._10.equals(number.getNumerationSystem())) {
            for (int i = 0; i < num.length(); i++) {
                char c = num.charAt(i);
                if (c != '0' && c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6' && c != '7' && c != '8' && c != '9')
                    return false;
            }
        }
        if (NumerationSystemType._12.equals(number.getNumerationSystem())) {
            for (int i = 0; i < num.length(); i++) {
                char c = num.charAt(i);
                if (c != '0' && c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6' && c != '7' && c != '8' && c != '9' && c != 'a' && c != 'b')
                    return false;
            }
        }
        if (NumerationSystemType._16.equals(number.getNumerationSystem())) {
            for (int i = 0; i < num.length(); i++) {
                char c = num.charAt(i);
                if (c != '0' && c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6' && c != '7' && c != '8' && c != '9' && c != 'a' && c != 'b' && c != 'c' && c != 'd' && c != 'e' && c != 'f')
                    return false;
            }
        }
//        for (NumerationSystem ns : numerationSystems
//                ) {
//            if (number.getNumerationSystem().equals(ns)) {
//                isCorrectSystem = true;
//                break;
//            }
//        }
//        return isCorrectSystem;
        return true;
    }
}
