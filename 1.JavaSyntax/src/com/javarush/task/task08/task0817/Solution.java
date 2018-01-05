package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String,String>h=new HashMap<>();
        h.put("f0","i0");
        h.put("f1","i1");
        h.put("f2","i2");
        h.put("f3","i3");
        h.put("f4","i4");
        h.put("f5","i5");
        h.put("f6","i6");
        h.put("f7","i7");
        h.put("f8","i8");
        h.put("f9","i9");

        return h;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //напишите тут ваш код
//        Iterator<Map.Entry<String,String>>it=map.entrySet().iterator();
//        while (it.hasNext()){
//            removeItemFromMapByValue(map,it.next().getValue());
//        }
        HashMap<String, String> hm = new HashMap<>();
        for(Map.Entry<String, String> item: map.entrySet()){
            int count=0;
            for (Map.Entry<String, String> pair: map.entrySet()) {
                String name = pair.getValue();
                if (item.getValue().equals(name))
//                    removeItemFromMapByValue(map, name);
                    count++;
            }
            if (count>1)
                hm.put(item.getKey(), item.getValue());
        }
        for (Map.Entry<String, String> item: hm.entrySet()) {
            String name = item.getValue();
            removeItemFromMapByValue(map, name);
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

    }
}
