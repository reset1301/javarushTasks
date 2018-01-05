package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private String name;
        private String surname;
        private boolean sex;
        private int age;
        private String work;
        private int stage;

        public Human() {
        }

        public Human(String name) {
            this.name = name;
        }

        public Human(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        public Human(String name, String surname, boolean sex) {
            this.name = name;
            this.surname = surname;
            this.sex = sex;
        }

        public Human(String name, String surname, boolean sex, int age) {
            this.name = name;
            this.surname = surname;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, String surname, boolean sex, int age, String work) {
            this.name = name;
            this.surname = surname;
            this.sex = sex;
            this.age = age;
            this.work = work;
        }

        public Human(String name, String surname, boolean sex, int age, String work, int stage) {
            this.name = name;
            this.surname = surname;
            this.sex = sex;
            this.age = age;
            this.work = work;
            this.stage = stage;
        }

        public Human(String name, boolean sex) {
            this.name = name;
            this.sex = sex;
        }

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, int age, String work, int stage) {
            this.name = name;
            this.age = age;
            this.work = work;
            this.stage = stage;
        }
    }
}
