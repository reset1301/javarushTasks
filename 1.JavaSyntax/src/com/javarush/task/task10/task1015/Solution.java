package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш
        ArrayList<String>[]s= new ArrayList[10];
            for (int i = 0; i < 10; i++){
                s[i] = new ArrayList<String>();
                for (int j = 0; j < 10; j++){
                    s[i].add(i + " " + j);
                }
        }
        return s;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}