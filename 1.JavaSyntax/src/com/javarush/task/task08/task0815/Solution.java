package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String,String>m=new HashMap<>();
        m.put("1","2");
        m.put("3","4");
        m.put("5","6");
        m.put("7","8");
        m.put("9","0");
        m.put("11","12");
        m.put("13","14");
        m.put("15","16");
        m.put("17","18");
        m.put("19","20");
        return m;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int count=0;
        for (Map.Entry<String,String>m:map.entrySet()) {
            if(m.getValue().equals(name))count++;
        }

        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
        int count=0;
        for (Map.Entry<String,String>m:map.entrySet()) {
            if(m.getKey().equals(lastName))count++;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
