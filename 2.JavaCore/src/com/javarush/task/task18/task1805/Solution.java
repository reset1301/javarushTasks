package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());
//        FileInputStream fileInputStream = new FileInputStream("c:\\111\\aaa.222");
        ArrayList<Integer> symb=new ArrayList<>();
        ArrayList<Integer>count=new ArrayList<>();
        int pos=0;
        while (fileInputStream.available()>0){
            int x=fileInputStream.read();
            boolean b = true;
            if (symb.size()==0){
                symb.add(pos,x);
                count.add(pos,1);
                pos++;
            }
            else {
                for (int i = 0; i < symb.size(); i++) {
                    if (symb.get(i) == x) {
                        count.set(i, count.get(i) + 1);
                        b = false;
                    }
                }
                if (b){
                    symb.add(pos,x);
                    count.add(pos,1);
                    pos++;
                }
            }
        }
        for (int i=0;i<symb.size()-1;i++)
            for (int j=0;j<symb.size()-1;j++)
                if (symb.get(j+1)<symb.get(j)){
                    int buf=symb.get(j+1);
                    symb.set(j+1,symb.get(j));
                    symb.set(j,buf);
                }
        for (int x:symb
             ) {
            System.out.print(x+" ");
        }
//        System.out.println(symb);
//        System.out.println(count);
        fileInputStream.close();

    }
}
