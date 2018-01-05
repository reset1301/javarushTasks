package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList <String > list = new ArrayList();
        list.add("peta");
        list.add("vasa");
        list.add("kola");
        list.add("masha");
        list.add("Igatii");
        System.out.println(list.size());
        for (int i = 0; i < 5; i ++) {
            System.out.println(list.get(i));
        }

    }
}
