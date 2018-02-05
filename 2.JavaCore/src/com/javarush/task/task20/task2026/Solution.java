package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

//        int count = 0;
//        for (int i = 0; i < a2.length; i++)
//            for (int j = 0; j < a2[i].length; j++) {
//                if (a2[i][j] == 1) {
//                    zero(a2, i, j);
//                    count++;
//                    i = 0;
//                    j = 0;
//                }
//            }
//        System.out.println(count);
        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 1) {
                    zero(a, i, j);
                    count++;
                    i = 0;
                    j = 0;
                }
            }
        return count;
    }

    public static void zero(byte[][] a, int x, int y) {
        for (int i = x; i < a.length; i++)
            if (a[i][y] == 0)
                i = a.length;
            else
                for (int j = y; j < a[i].length; j++) {
                    if (a[i][j] == 0)
                        j = a[i].length;
                    else a[i][j] = 0;
                }
//        for (int i = 0; i < a.length; i++) {
//            for (int j = 0; j < a[i].length; j++) {
//                System.out.print(a[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
    }
}
