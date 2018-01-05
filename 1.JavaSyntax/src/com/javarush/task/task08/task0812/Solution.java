package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer>a=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            a.add(Integer.parseInt(br.readLine()));
        }
        int x=1,maxx=x;
        for (int i = 0; i < 9; i++) {
            if(a.get(i)==a.get(i+1)) {
                x++;
                if(x>maxx)maxx=x;
            }
            else{
                if(x>maxx)
                    maxx=x;
                x=1;
            }
        }
        System.out.println(maxx);
    }
}