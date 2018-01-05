package com.javarush.task.task09.task0906;

/* 
Логирование стек трейса
*/

public class Solution {
    public static void main(String[] args) {
        log("In main method");
    }

    public static void log(String s) {
        //напишите тут ваш код
        StackTraceElement[]st=Thread.currentThread().getStackTrace();
        String s1=new String();
        s1=st[2].getClassName()+": "+st[2].getMethodName()+": "+s;
//        for (StackTraceElement tr:st ) {
////            System.out.println(tr.getMethodName()+" "+tr.getClassName());
//            s1=tr.getClassName()+": "+tr.getMethodName()+": "+s;
//        }
        System.out.println(s1);
    }
}
