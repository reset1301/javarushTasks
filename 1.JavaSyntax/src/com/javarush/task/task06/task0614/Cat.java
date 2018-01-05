package com.javarush.task.task06.task0614;

import java.util.ArrayList;

/* 
Статические коты
*/

public class Cat {
    //напишите тут ваш код
    public static ArrayList cats = new ArrayList();

    public Cat() {
    }

    public static void main(String[] args) {
        //напишите тут ваш код
        for (int i = 0; i < 10; i++) {
            Cat c=new Cat();
            cats.add(c);
        }
        printCats();
    }

    public static void printCats() {
        //напишите тут ваш код
        for (Object state : cats) {
            System.out.println(state);

        }

    }
}
