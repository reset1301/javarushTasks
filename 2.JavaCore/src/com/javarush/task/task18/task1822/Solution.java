package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        int id = Integer.parseInt(args[0]);
        BufferedReader f1 = new BufferedReader(new FileReader(s1));
        String s, searchstr = "", searchId, searchproductName, searchprice, searchquantity;
        while ((s = f1.readLine()) != null) {
            String[] s2 = s.split(" ");
            if (Integer.parseInt(s2[0]) == id) {
                searchstr = s;
//                searchprice
//                searchquantity
                break;
            }
        }
        System.out.println(searchstr);
        f1.close();
    }
}
