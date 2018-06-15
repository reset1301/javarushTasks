package com.javarush.task.task30.task3013;

/* 
Набираем код
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int number = Integer.MAX_VALUE - 133;
        int number = 1073741824;
        System.out.println(Integer.toString(number, 2));

        String result = Integer.toString(solution.resetLowerBits(number), 2);
        System.out.println(result);
    }

    public int resetLowerBits(int number) {
        //напишите тут ваш код
        number |= number >> 1;
//        System.out.println("number |= number >> 1 : "+Integer.toString(number, 2));
        number |= number >> 2;
//        System.out.println("number |= number >> 2 : "+Integer.toString(number, 2));
        number |= number >> 4;
//        System.out.println("number |= number >> 4 : "+Integer.toString(number, 2));
        number &= ~number >> 1;
        return number;
    }
}