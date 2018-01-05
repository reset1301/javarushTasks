package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;
        key=reader.readLine();
        //тут цикл по чтению ключей, пункт 1
        while ((key.equals("user"))||(key.equals("loser"))||(key.equals("coder"))||(key.equals("proger")))
        {
            //создаем объект, пункт 2
            if (key.equals("user")){
                person=new Person.User();
            }
            else if (key.equals("loser")){
                person=new Person.Loser();
            }
            else if (key.equals("coder")){
                person=new Person.Coder();
            }
            else {
                person=new Person.Proger();
            }
            doWork(person); //вызываем doWork
            key=reader.readLine();
        }
    }

    public static void doWork(Person person) {
        // пункт 3
        if (person instanceof Person.User)
            ((Person.User) person).live();
        else if (person instanceof Person.Loser)
            ((Person.Loser) person).doNothing();
        else if (person instanceof Person.Coder)
            ((Person.Coder) person).coding();
        else if (person instanceof Person.Proger)
            ((Person.Proger) person).enjoy();
    }
}
