package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        //напишите тут ваш код
        HashSet<Integer>h=new HashSet<>();
        h.add(1);
        h.add(2);
        h.add(3);
        h.add(4);
        h.add(5);
        h.add(6);
        h.add(7);
        h.add(8);
        h.add(9);
        h.add(10);
        h.add(11);
        h.add(12);
        h.add(13);
        h.add(14);
        h.add(15);
        h.add(16);
        h.add(17);
        h.add(18);
        h.add(19);
        h.add(20);

        return h;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {
        //напишите тут ваш код
        Iterator it=set.iterator();
        while (it.hasNext()){
            int buf=(int)it.next();
            if(buf>10)it.remove();
        }
        return set;
    }

    public static void main(String[] args) {
    }
}
