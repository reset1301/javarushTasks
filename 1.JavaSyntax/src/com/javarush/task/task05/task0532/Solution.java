package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //напишите тут ваш код
        int N = Integer.parseInt(reader.readLine());
        int maximum = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int next = Integer.parseInt(reader.readLine());
            if (next>maximum)
                maximum = next;

//            maximum = maximum >= next ? maximum : next;
        }
//        reader.close();

        System.out.println(maximum);
    }
}
