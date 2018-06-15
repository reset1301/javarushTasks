package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        int id = Integer.parseInt(reader.readLine());
//        String name;// = reader.readLine();
//
////        System.out.println("Id=" + id + " Name=" + name);
//
//        HashMap<Integer, String> map = new HashMap<>();
//        while (!(name = reader.readLine()).equals("")) {
//            if (map.containsValue(name)) {
//                for (Map.Entry<Integer, String> m : map.entrySet()
//                        ) {
//                    System.out.println(m.getValue() + " " + m.getKey());
//                }
//                map.clear();
//            }
//            map.put(id, name);
//            id = Integer.parseInt(reader.readLine());
//        }
//        reader.close();
//        for (Map.Entry<Integer, String> m : map.entrySet()
//                ) {
//            System.out.println(m.getValue() + " " + m.getKey());
//        }
        HashMap<String, String> map = new HashMap<>();
        while (true) {
            String id = reader.readLine();
            String name = reader.readLine();
            if (id.isEmpty()) break;
            map.put(name, id);
        }
        map.forEach((key, volue)-> {
            System.out.println(volue + " " + key);});
    }
}
