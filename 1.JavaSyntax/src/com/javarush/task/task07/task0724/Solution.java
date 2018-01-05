package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human gf1=new Human("aaa",true,60);
        Human gf2=new Human("bbb",true,55);
        Human gm1=new Human("ccc",false,65);
        Human gm2=new Human("ddd",false,50);
        Human f=new Human("eee",true,30,gf1,gm1);
        Human m=new Human("fff",false,25,gf2,gm2);
        Human c1=new Human("ggg",false,10,f,m);
        Human c2=new Human("hhh",false,5,f,m);
        Human c3=new Human("iii",false,3,f,m);
        System.out.println("Имя: "+gf1.name+" пол: "+gf1.sex+" возраст: "+gf1.age);
        System.out.println("Имя: "+gf2.name+" пол: "+gf2.sex+" возраст: "+gf2.age);
        System.out.println("Имя: "+gm1.name+" пол: "+gm1.sex+" возраст: "+gm1.age);
        System.out.println("Имя: "+gm2.name+" пол: "+gm2.sex+" возраст: "+gm2.age);
        System.out.println("Имя: "+f.name+" пол: "+f.sex+" возраст: "+f.age+" отец: "+f.father+" мать: "+f.mother);
        System.out.println("Имя: "+m.name+" пол: "+m.sex+" возраст: "+m.age+" отец: "+m.father+" мать: "+m.mother);
        System.out.println("Имя: "+c1.name+" пол: "+c1.sex+" возраст: "+c1.age+" отец: "+c1.father+" мать: "+c1.mother);
        System.out.println("Имя: "+c2.name+" пол: "+c2.sex+" возраст: "+c2.age+" отец: "+c2.father+" мать: "+c2.mother);
        System.out.println("Имя: "+c3.name+" пол: "+c3.sex+" возраст: "+c3.age+" отец: "+c3.father+" мать: "+c3.mother);
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















