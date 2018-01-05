package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String s =br.readLine(),st;
        br.close();
        FileInputStream f = new FileInputStream(s);
        br=new BufferedReader(new InputStreamReader(f));
        ArrayList<Integer>a = new ArrayList<>();
//        while (f.available()>0){
        st=br.readLine();
        while (st !=  null){
            int x=Integer.parseInt(st);
//            System.out.println(x);
            st=br.readLine();
            if (x%2==0)
                a.add(x);
        }
        f.close();
//        System.out.println(System.lineSeparator());
        Collections.sort(a);
        for (int x:a
             ) {
            System.out.println(x);
        }
    }
}
