package com.javarush.task.task34.task3404;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/*
Рекурсия для мат. выражения
*/
//public class Solution {
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.recursion("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
//        solution.recursion("cos(2*(-5+1.5*4)+28)-sin(2*(-5+1.5*4)+28)", 0); //expected output 0.37 13
//        solution.recursion("1^cos(0)", 0); //expected output 1 2
//    }
//
//    public void recursion(final String expression, int countOperation) {
//        //implement
//        String expression1 = expression.replaceAll(" ", "");
//        countOperation = getCountOperation(expression1) > countOperation ?
//                getCountOperation(expression1) :
//                countOperation;
//        System.out.println(countOperation);
//        expression1 = expression.replaceAll(" ", "");
//        int firstSin = expression1.indexOf("sin") == -1 ? 1000 : expression1.indexOf("sin");
//        int firstCos = expression1.indexOf("cos") == -1 ? 1000 : expression1.indexOf("cos");
//        int firstTan = expression1.indexOf("tan") == -1 ? 1000 : expression1.indexOf("tan");
//        int firstPlus = expression1.indexOf("+") == -1 ? 1000 : expression1.indexOf("+");
//        int firstMinus = expression1.indexOf("-") == -1 ? 1000 : expression1.indexOf("-");
//        int firstMult = expression1.indexOf("*") == -1 ? 1000 : expression1.indexOf("*");
//        int firstDivide = expression1.indexOf("/") == -1 ? 1000 : expression1.indexOf("/");
//        int firstPow = expression1.indexOf("^") == -1 ? 1000 : expression1.indexOf("^");
////        System.out.println(Math.cos(Math.toRadians(60)));
//    }
//
//    public int getCountOperation(String expression1) {
//        int countOperation = 0;
//        while (expression1.length() > 0) {
//            int firstSin = expression1.indexOf("sin") == -1 ? 1000 : expression1.indexOf("sin");
//            int firstCos = expression1.indexOf("cos") == -1 ? 1000 : expression1.indexOf("cos");
//            int firstTan = expression1.indexOf("tan") == -1 ? 1000 : expression1.indexOf("tan");
//            int firstPlus = expression1.indexOf("+") == -1 ? 1000 : expression1.indexOf("+");
//            int firstMinus = expression1.indexOf("-") == -1 ? 1000 : expression1.indexOf("-");
//            int firstMult = expression1.indexOf("*") == -1 ? 1000 : expression1.indexOf("*");
//            int firstDivide = expression1.indexOf("/") == -1 ? 1000 : expression1.indexOf("/");
//            int firstPow = expression1.indexOf("^") == -1 ? 1000 : expression1.indexOf("^");
//            if ((firstSin + firstCos + firstTan + firstPlus + firstMinus + firstMult + firstDivide + firstPow) == 8000)
//                break;
//            countOperation++;
//            if (firstSin < firstCos && firstSin < firstTan && firstSin < firstPlus
//                    && firstSin < firstMinus && firstSin < firstMult && firstSin < firstDivide &&
//                    firstSin < firstPow) {
//                expression1 = expression1.substring(expression1.indexOf("sin") + 4);
//            }
//            if (firstCos < firstSin && firstCos < firstTan && firstCos < firstPlus
//                    && firstCos < firstMinus && firstCos < firstMult && firstCos < firstDivide &&
//                    firstCos < firstPow) {
//                expression1 = expression1.substring(expression1.indexOf("cos") + 4);
//            }
//            if (firstTan < firstCos && firstTan < firstSin && firstTan < firstPlus
//                    && firstTan < firstMinus && firstTan < firstMult && firstTan < firstDivide &&
//                    firstTan < firstPow) {
//                expression1 = expression1.substring(expression1.indexOf("tan") + 4);
//            }
//            if (firstPlus < firstCos && firstPlus < firstTan && firstPlus < firstSin
//                    && firstPlus < firstMinus && firstPlus < firstMult && firstPlus < firstDivide &&
//                    firstPlus < firstPow) {
//                expression1 = expression1.substring(expression1.indexOf("+") + 1);
//            }
//            if (firstMinus < firstCos && firstMinus < firstTan && firstMinus < firstPlus
//                    && firstMinus < firstSin && firstMinus < firstMult && firstMinus < firstDivide &&
//                    firstMinus < firstPow) {
//                expression1 = expression1.substring(expression1.indexOf("-") + 1);
//            }
//            if (firstMult < firstCos && firstMult < firstTan && firstMult < firstPlus
//                    && firstMult < firstMinus && firstMult < firstSin && firstMult < firstDivide &&
//                    firstMult < firstPow) {
//                expression1 = expression1.substring(expression1.indexOf("*") + 1);
//            }
//            if (firstDivide < firstCos && firstDivide < firstTan && firstDivide < firstPlus
//                    && firstDivide < firstMinus && firstDivide < firstMult && firstSin > firstDivide &&
//                    firstDivide < firstPow) {
//                expression1 = expression1.substring(expression1.indexOf("/") + 1);
//            }
//            if (firstPow < firstCos && firstPow < firstTan && firstPow < firstPlus
//                    && firstPow < firstMinus && firstPow < firstMult && firstPow < firstDivide &&
//                    firstPow < firstSin) {
//                expression1 = expression1.substring(expression1.indexOf("^") + 1);
//            }
//        }
//        return countOperation;
//    }
//
//    public Solution() {
//        //don't delete
//    }
//}
/* Рекурсия для мат.выражения
На вход подается строка - математическое выражение.
Выражение включает целые и дробные числа, скобки (), пробелы, знак отрицания -, возведение в степень ^, sin(x), cos(x), tan(x)
Для sin(x), cos(x), tan(x) выражение внутри скобок считать градусами, например, cos(3 + 19*3)=0.5
Степень задается так: a^(1+3) и так a^4, что эквивалентно a*a*a*a.
С помощью рекурсии вычислить выражение и количество математических операций. Вывести через пробел результат в консоль.
Результат выводить с точностью до двух знаков, для 0.33333 вывести 0.33, использовать стандартный принцип округления.
Не создавайте статические переменные и поля класса.
Не пишите косвенную рекурсию.
Пример, состоящий из операций sin * - + * +:
sin(2*(-5+1.5*4)+28)
Результат:
0.5 6
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recursion("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6


    }

    public void recursion(final String expression, int countOperation) {
        //implement
        Locale.setDefault(Locale.ENGLISH);
        DecimalFormat df = new DecimalFormat("#.##");
        String value = expression.replaceAll(" ", "");
        int currentCountOperation = countOperation + 1;
        int inside = 0;
        int p1 = -1, p2 = -1, p3 = -1;
        char[] s = value.toCharArray();
        for (int i = s.length - 1; i >= 0; i--) {
            switch (s[i]) {
                case '^':
                    if (inside == 0 && p3 == -1) p3 = i;
                    break;
                case '*':
                case '/':
                    if (inside == 0 && p2 == -1) p2 = i;
                    break;
                case '+':
                case '-':
                    if (inside == 0 && p1 == -1) p1 = i;
                    break;
                case '(':
                    inside++;
                    break;
                case ')':
                    inside--;
                    break;
            }
        }
        if (p1 != -1) p2 = p1;
        if (p2 != -1) p3 = p2;
        if (p3 != -1) {
            PrintStream oldStream = System.out;
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PrintStream newStream = new PrintStream(outputStream);
            System.setOut(newStream);
            recursion(value.substring(0, p3), currentCountOperation);
            String[] part1 = outputStream.toString().split("\\s");
            currentCountOperation = currentCountOperation < Integer.parseInt(part1[1]) ? Integer.parseInt(part1[1]) : currentCountOperation;
            outputStream.reset();
            recursion(value.substring(p3 + 1), currentCountOperation);
            String[] part2 = outputStream.toString().split("\\s");
            currentCountOperation = currentCountOperation < Integer.parseInt(part2[1]) ? Integer.parseInt(part2[1]) : currentCountOperation;
            System.setOut(oldStream);
            switch (s[p3]) {
                case '^':
                    customPrint(df, Math.rint(100.0 *(Math.pow(Double.parseDouble(part1[0]), Double.parseDouble(part2[0]))))/100, countOperation, currentCountOperation);
                    return;
                case '*':
                    customPrint(df,  Math.rint(100.0 *(Double.parseDouble(part1[0]) * Double.parseDouble(part2[0])))/100, countOperation, currentCountOperation);
                    return;
                case '/':
                    customPrint(df,  Math.rint(100.0 *(Double.parseDouble(part1[0]) / Double.parseDouble(part2[0])))/100, countOperation, currentCountOperation);
                    return;
                case '+':
                    customPrint(df,  Math.rint(100.0 *(Double.parseDouble(part1[0]) + Double.parseDouble(part2[0])))/100, countOperation, currentCountOperation);
                    return;
                case '-':
                    customPrint(df,  Math.rint(100.0 *(Double.parseDouble(part1[0]) - Double.parseDouble(part2[0])))/100, countOperation, currentCountOperation);
                    return;
            }
        }
        if (s.length > 0 && s[0] == '(' && s[s.length - 1] == ')') {
            recursion(value.substring(1, s.length - 1), countOperation);
            return;
        }
        if (s.length > 5 && Character.isAlphabetic(s[0]) && s[3] == '(' && s[s.length - 1] == ')') {
            String funcName = value.substring(0, 3);
            PrintStream oldStream = System.out;
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PrintStream newStream = new PrintStream(outputStream);
            System.setOut(newStream);
            recursion(value.substring(4, s.length - 1), currentCountOperation);
            String[] part = outputStream.toString().split("\\s");
            currentCountOperation = currentCountOperation < Integer.parseInt(part[1]) ? Integer.parseInt(part[1]) : currentCountOperation;
            System.setOut(oldStream);
            if ("sin".equals(funcName)) {
                customPrint(df,  Math.rint(100.0 *(Math.sin(Math.toRadians(Double.parseDouble(part[0])))))/100, countOperation, currentCountOperation);
                return;
            }
            if ("cos".equals(funcName)) {
                customPrint(df,  Math.rint(100.0 *(Math.cos(Math.toRadians(Double.parseDouble(part[0])))))/100, countOperation, currentCountOperation);
                return;
            }
            if ("tan".equals(funcName)) {
                customPrint(df,  Math.rint(100.0 *(Math.tan(Math.toRadians(Double.parseDouble(part[0])))))/100, countOperation, currentCountOperation);
                return;
            }
        }
        double n = 0d;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length && (Character.isDigit(s[i]) || s[i] == '.'); i++) {
            sb.append(s[i]);
        }
        if (sb.length() > 0) {
            n = Double.parseDouble(sb.toString());
        }
        customPrint(df, n, countOperation, countOperation);
    }
    private void customPrint(DecimalFormat df, double v, int countOperation, int currentCountOperation) {
        v = (Math.rint(100.0 * v) / 100);
        String rez = String.valueOf(v);
        if (rez.endsWith(".0"))
        {
            rez = rez.replace(".0","");
        }

        if (countOperation == 0) {
            System.out.println(rez + " " + currentCountOperation);
        } else {
            System.out.println(rez + " " + currentCountOperation);
        }
    }
    public Solution() {
        //don't delete
    }
}