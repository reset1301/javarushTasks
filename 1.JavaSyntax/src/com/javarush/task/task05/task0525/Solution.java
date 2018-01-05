package com.javarush.task.task05.task0525;

/* 
И целой утки мало
*/

public class Solution {

    public static void main(String[] args) {
        Duck duck1 = new Duck();
        Duck duck2 = new Duck();
        System.out.println(duck1);
        System.out.println(duck2);
        Cat c1=new Cat(),c2=new Cat();
        Dog d1=new Dog(),d2=new Dog();
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(d1);
        System.out.println(d2);


        //напишите тут ваш код
    }

    public static class Duck {
        public String toString() {
            return "Duck";
        }
    }

    //напишите тут ваш код

    public static class Cat{
        public String toString(){
            return "Cat";
        }
    }

    public static class Dog{
        public String toString(){
            return "Dog";
        }
    }
}
