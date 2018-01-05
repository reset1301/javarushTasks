package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String,Integer>h=new HashMap<>();
        h.put("1",100);
        h.put("2",200);
        h.put("3",300);
        h.put("4",400);
        h.put("5",500);
        h.put("6",600);
        h.put("7",700);
        h.put("8",800);
        h.put("9",900);
        h.put("0",1000);

        return h;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String,Integer>> it=map.entrySet().iterator();
        while (it.hasNext()){
            if(it.next().getValue()<500) it.remove();
        }
    }

    public static void main(String[] args) {

    }
}