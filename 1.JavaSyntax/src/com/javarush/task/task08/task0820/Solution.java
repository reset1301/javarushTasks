package com.javarush.task.task08.task0820;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Множество всех животных
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        HashSet<Cat> result = new HashSet<Cat>();
        //напишите тут ваш код
        for (int i = 0; i < 4; i++) {
            result.add(new Cat());
        }

        return result;
    }

    public static Set<Dog> createDogs() {
        //напишите тут ваш код
        HashSet<Dog>d=new HashSet<>();
        for (int i = 0; i < 3; i++) {
            d.add(new Dog());
        }
        return d;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        //напишите тут ваш код
        HashSet<Object> h=new HashSet<>();
        for (Cat c:cats) {
            h.add(c);
        }
        for (Dog d:dogs) {
            h.add(d);
        }
        return h;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        //напишите тут ваш код
        for (Cat cat:cats) {
            Iterator<Object> iterator = pets.iterator();
            while (iterator.hasNext()){
                Object c = iterator.next();
                if (c.equals(cat))
                    iterator.remove();

            }
        }
    }

    public static void printPets(Set<Object> pets) {
        //напишите тут ваш код
        for (Object o:pets) {
            System.out.println(o);
        }
    }

    //напишите тут ваш код
    public static class Cat{}
    public static class Dog{}

}
