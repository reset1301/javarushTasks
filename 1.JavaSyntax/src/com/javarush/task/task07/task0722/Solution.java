package com.javarush.task.task07.task0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Это конец
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        ArrayList<String>s=new ArrayList<>();
        for (int i = 0; i < 10; ) {
            String buf=reader.readLine();
            if(buf.equals("end")) break;
            else s.add(buf);
        }
        for (int i = 0; i < s.size(); i++) {
            System.out.println(s.get(i));
        }
    }
}