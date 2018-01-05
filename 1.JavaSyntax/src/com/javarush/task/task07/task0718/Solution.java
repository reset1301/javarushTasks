package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String>l=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            l.add(br.readLine());
        }
        int b=-1;
        for (int i = 0; i < 9; i++) {
            if(l.get(i).length()>l.get(i+1).length()){
                b=i+1;
                break;
            }
        }
        if(b!=-1)
            System.out.println(b);
    }
}

