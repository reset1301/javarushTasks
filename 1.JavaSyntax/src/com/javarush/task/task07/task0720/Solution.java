package com.javarush.task.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Перестановочка подоспела
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //напишите тут ваш код
        ArrayList<String>s=new ArrayList<>();
//        System.out.println("N, M = ");
        int N=Integer.parseInt(reader.readLine());
        int M=Integer.parseInt(reader.readLine());
        for (int i = 0; i < N; i++) {
            s.add(reader.readLine());
        }
        for (int i = 0; i < M; i++) {
//            String buf=s.get(0);
            s.add(s.get(0));
            s.remove(0);
//            s.add(buf);
        }
        for (int i = 0; i < s.size(); i++) {
            System.out.println(s.get(i));
        }


    }
}
