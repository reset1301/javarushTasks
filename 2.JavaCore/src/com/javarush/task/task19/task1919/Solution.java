package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        String fileName=br.readLine();
//        br.close();
        BufferedReader br=new BufferedReader(new FileReader(args[0]));
        Map<String,Double> map=new TreeMap<>();
        while (br.ready()){
            String[]s=br.readLine().split(" ");
            if (map.containsKey(s[0])){
                map.put(s[0],map.get(s[0])+Double.parseDouble(s[1]));
            }
            else {
                map.put(s[0],Double.parseDouble(s[1]));
            }
        }
        br.close();
//        map.entrySet().stream()
//                .sorted(Map.Entry<String, Double>.comparingByKey().reversed());
        for (Map.Entry<String,Double> mm:map.entrySet()
             ) {
            System.out.println(mm.getKey()+" "+mm.getValue());
        }
    }
}
