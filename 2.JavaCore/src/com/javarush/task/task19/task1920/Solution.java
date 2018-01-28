package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> map = new HashMap<>();
        while (br.ready()) {
            String[] s = br.readLine().split(" ");
            if (map.containsKey(s[0])) {
                map.put(s[0], map.get(s[0]) + Double.parseDouble(s[1]));
            } else
                map.put(s[0], Double.parseDouble(s[1]));
        }
        br.close();
        double max = 0;
        for (Map.Entry<String, Double> mm : map.entrySet()
                ) {
            if (mm.getValue() > max)
                max = mm.getValue();
        }
        ArrayList<String>names=new ArrayList<>();
        for (Map.Entry<String,Double>mm:map.entrySet()
             ) {
            if (mm.getValue()==max){
                names.add(mm.getKey());
            }
        }
        Collections.sort(names);
//        System.out.println(names);
        for (String s:names
             ) {
            System.out.println(s);
        }
    }
}
