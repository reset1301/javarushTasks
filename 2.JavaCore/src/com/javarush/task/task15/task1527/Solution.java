package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;

/*
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //add your code here
        String text = reader.readLine();
        reader.close();
        String line = text.substring(text.indexOf("?") + 1);
        String[] n = line.split("&");
        for (String a : n) {
            System.out.print(a.split("=")[0] + " ");
        }
        System.out.println();
        for (String a : n) {
            try {
                if (a.split("=")[0].equals("obj")) {
                    alert(Double.parseDouble(a.split("=")[1]));
                }
            } catch (Exception e) {
                alert(a.split("=")[1]);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
