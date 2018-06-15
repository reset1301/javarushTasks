package com.javarush.task.task30.task3009;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/* 
Палиндром?
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String number) {
        Set<Integer> radixs = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        BigInteger bi=null;
        try {
            bi = new BigInteger(number, 10);
        } catch (NumberFormatException e) {
            return radixs;
        }
        for (int i = 2; i <= 36; i++) {
            StringBuilder ans = new StringBuilder(bi.toString(i));
            if (ans.toString().equals(ans.reverse().toString())) {
                radixs.add(i);
            }
        }
        return radixs;
    }
}