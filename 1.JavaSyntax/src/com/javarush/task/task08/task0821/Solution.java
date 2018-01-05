package com.javarush.task.task08.task0821;



import java.util.HashMap;

import java.util.Map;



/*

Однофамильцы и тёзки

*/

public class Solution

{

    public static void main(String[] args)

    {

        Map<String, String> map = createPeopleList();

        printPeopleList(map);

    }



    public static Map<String, String> createPeopleList()

    {

        //напишите тут ваш код

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < 9; i++) {

            map.put("F"+(i+1), "N"+(i+1));

        }

        map.put("F"+9, "N"+9);

        return map;

    }



    public static void printPeopleList(Map<String, String> map)

    {

        for (Map.Entry<String, String> s : map.entrySet())

        {

            System.out.println(s.getKey() + " " + s.getValue());

        }

    }



}