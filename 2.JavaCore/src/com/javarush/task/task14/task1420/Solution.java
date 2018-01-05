package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int a=-10,b=-10;
        try {
            a = Integer.parseInt(br.readLine());
            if (a<=0)
                throw new NumberFormatException();
            b = Integer.parseInt(br.readLine());
            if (b<=0)
                throw new NumberFormatException();
        }
        catch (IOException e){
            System.out.println(e);
        }
//        if (a>0&&b>0){
            while(a!=b){
                if (a>b)
                    a-=b;
                else b-=a;
            }
            System.out.println(a);
//        }
    }
}
