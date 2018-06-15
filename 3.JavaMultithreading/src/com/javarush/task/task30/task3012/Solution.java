package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(2);
    }

    public void createExpression(int number) {
        //напишите тут ваш код
        StringBuilder result = new StringBuilder(number + " =");
        StringBuilder ans = new StringBuilder();
        while (number >= 3) {
            if (number % 3 == 2) {
                ans.append("-");
                number /= 3;
                number++;
            } else if (number % 3 == 1) {
                ans.append("+");
                number /= 3;
            } else {
                ans.append("0");
                number /= 3;
            }
        }
        if (number == 2) {
            ans.append("-+");
        } else if (number == 1) {
            ans.append("+");
        }
        String simmetrical = ans.reverse().toString();
//        System.out.println(simmetrical);
        int step3 = 1;
        for (int i = simmetrical.length() - 1; i >= 0; i--) {
            if (simmetrical.charAt(i) == '+')
                result.append(" + ").append(step3);
            else if (simmetrical.charAt(i) == '-')
                result.append(" - ").append(step3);
            step3 *= 3;
        }
        System.out.println(result.toString());
    }
}