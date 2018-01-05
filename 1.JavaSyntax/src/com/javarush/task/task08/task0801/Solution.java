package com.javarush.task.task08.task0801;

/* 
HashSet из растений
*/

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        HashSet<String>h=new HashSet<>();
        h.add("арбуз");
        h.add("банан");
        h.add("вишня");
        h.add("груша");
        h.add("дыня");
        h.add("ежевика");
        h.add("жень-шень");
        h.add("земляника");
        h.add("ирис");
        h.add("картофель");

        for (String hh:h) {
            System.out.println(hh);
        }

    }
}
