package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone1", new Date("JUNE 1 1980"));
        map.put("Stallone2", new Date("FEBRUALY 9 1982"));
        map.put("Stallone3", new Date("JUNE 17 1983"));
        map.put("Stallone4", new Date("MARCH 11 1984"));
        map.put("Stallone5", new Date("APRIL 13 1986"));
        map.put("Stallone6", new Date("MAY 8 1987"));
        map.put("Stallone7", new Date("JULY 19 1988"));
        map.put("Stallone8", new Date("AUGUST 4 1992"));
        map.put("Stallone9", new Date("JUNE 23 1995"));
        map.put("Stallone10", new Date("JUNE 31 1998"));
        return map;
        //напишите тут ваш код
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {

        Iterator <Map.Entry<String,Date>> inter = map.entrySet().iterator();
        while(inter.hasNext()) {
            int month = inter.next().getValue().getMonth();
            if ((month ==5) ||(month  == 6)||(month ==7)) {
                inter.remove();
            }

        }
    }


    //напишите тут ваш код



    public static void main(String[] args) {


    }
}