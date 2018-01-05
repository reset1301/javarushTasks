package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        Map<String,Cat>c=new HashMap<>();
        c.put("1",new Cat("1"));
        c.put("2",new Cat("2"));
        c.put("3",new Cat("3"));
        c.put("4",new Cat("4"));
        c.put("5",new Cat("5"));
        c.put("6",new Cat("6"));
        c.put("7",new Cat("7"));
        c.put("8",new Cat("8"));
        c.put("9",new Cat("9"));
        c.put("0",new Cat("0"));

        return c;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        HashSet<Cat>s=new HashSet<>();
        for (Map.Entry<String,Cat>m:map.entrySet()             ) {
            s.add(m.getValue());
        }
        return s;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
