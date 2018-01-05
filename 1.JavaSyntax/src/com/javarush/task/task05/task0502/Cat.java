package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public String name;
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        int firstStat = age * weight * strength;
        int secondStat = anotherCat.age * anotherCat.weight * anotherCat.strength;

        if (firstStat > secondStat) return true;
        else return false;
    }

    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.name = "1"; cat1.age = 1;
        cat1.weight = 1; cat1.strength = 1;

        Cat cat2 = new Cat();
        cat2.name = "2"; cat2.age = 2;
        cat2.weight = 2; cat2.strength = 2;

        Cat cat3 = new Cat();
        cat3.name = "3"; cat3.age = 3;
        cat3.weight = 3; cat3.strength = 3;
        //System.out.println(c1.fight(c2));

    }
}
