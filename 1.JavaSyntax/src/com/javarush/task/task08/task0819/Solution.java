package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        for (Cat text : cats) {

            cats.remove(cats);

            break;

            // System.out.println(text);
        }

        //напишите тут ваш код. step 3 - пункт 3

        printCats(cats);

    }

    public static Set<Cat> createCats() {
        //напишите тут ваш код. step 2 - пункт 2
        HashSet <Cat> set = new HashSet<Cat>();

        Cat cat = new Cat();
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        set.add(cat1);
        set.add(cat);
        set.add(cat2);

        return set;
    }

    public static void printCats(Set<Cat> cats) {
        // step 4 - пункт 4
        //  Set<Cat> printcat = new HashSet<Cat>();

        for (Cat text : cats) {
            System.out.println(text);
        }
    }

    public  static  class Cat {

    }
    // step 1 - пункт 1
}