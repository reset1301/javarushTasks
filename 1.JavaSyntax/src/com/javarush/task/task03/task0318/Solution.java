package com.javarush.task.task03.task0318;

/* 
План по захвату мира
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String name;
    //    System.out.print("Name = ");
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    //    System.out.print("Age = ");
        int a=Integer.parseInt(r.readLine());
        name=r.readLine();

        System.out.println(name+" захватит мир через "+a+" лет. Му-ха-ха!");
    }
}
