package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try {

            String number = args[0].toLowerCase();
//        String number = "00".toLowerCase();
            BigInteger bi = null;
            boolean flag = false;
            ArrayList<Integer> list = new ArrayList<>(number.length());
            for (int i = 0; i < number.length(); i++) {
                list.add(0);
            }
            for (int j = 0; j < number.length(); j++) {
                for (int i = 2; i <= 36; i++) {
                    try {
                        String c = number.charAt(j) + "";
                        bi = new BigInteger(c.toString(), i);
                        list.set(j, i);
//                    System.out.println(i);
//                    flag = true;
                        break;
                    } catch (Exception e) {
                    }
                }
            }
//        System.out.println(list);
            int min = 50,max=0;
            for (int i = 0; i < list.size(); i++) {
                if (min > list.get(i)) {
                    min = list.get(i);
                }
                if (max < list.get(i)) {
                    max = list.get(i);
                }

            }
            if (min==0) {
                System.out.println("incorrect");
            }
            else System.out.println(max);
//        if (!flag) {
//            System.out.println("incorrect");
//        }
        }catch (Exception e){}
    }
}