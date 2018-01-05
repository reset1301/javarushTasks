package com.javarush.task.task07.task0716;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        list.add("роза"); //0
        list.add("лоза"); //1
        list.add("лира"); //2
        list = fix(list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {
        //напишите тут ваш код
        ArrayList<String>l1=new ArrayList<>();
        for (String s:list) {
            if ((s.lastIndexOf("л") != -1) && (s.lastIndexOf("р") == -1)){
                l1.add(s);
                l1.add(s);
            }
            else if(((s.lastIndexOf("л") != -1) && (s.lastIndexOf("р") != -1))||
                    ((s.lastIndexOf("л") == -1) && (s.lastIndexOf("р") == -1)))
                l1.add(s);

        }
        //System.out.println(list.get(0).lastIndexOf("п"));
        return l1;
    }
}