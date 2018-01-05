package com.javarush.task.task09.task0902;

/* 
И снова StackTrace
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        method1();
    }

    public static String method1() {
        method2();
        //напишите тут ваш код
        int count=0;
        String s1=new String();
        StackTraceElement[]st=Thread.currentThread().getStackTrace();
        for (StackTraceElement s:st ) {
//            System.out.println(s.getMethodName());
            s1= s.getMethodName();
            if(count==2) break;
            count++;
        }
        return s1;
    }

    public static String method2() {
        method3();
        //напишите тут ваш код
        int count=0;
        String s1=new String();
        StackTraceElement[]st=Thread.currentThread().getStackTrace();
        for (StackTraceElement s:st ) {
//            System.out.println(s.getMethodName());
            s1= s.getMethodName();
            if(count==2) break;
            count++;
        }
        return s1;
    }

    public static String method3() {
        method4();
        //напишите тут ваш код
        int count=0;
        String s1=new String();
        StackTraceElement[]st=Thread.currentThread().getStackTrace();
        for (StackTraceElement s:st ) {
//            System.out.println(s.getMethodName());
            s1= s.getMethodName();
            if(count==2) break;
            count++;
        }
        return s1;
    }

    public static String method4() {
        method5();
        //напишите тут ваш код
        int count=0;
        String s1=new String();
        StackTraceElement[]st=Thread.currentThread().getStackTrace();
        for (StackTraceElement s:st ) {
//            System.out.println(s.getMethodName());
            s1= s.getMethodName();
            if(count==2) break;
            count++;
        }
        return s1;
    }

    public static String method5() {
        //напишите тут ваш код
        String s1=new String();
        int count=0;
        StackTraceElement[]st=Thread.currentThread().getStackTrace();
        for (StackTraceElement s:st ) {
//            System.out.println(s.getMethodName());
            s1= s.getMethodName();
            if(count==2) break;
            count++;
        }
        return s1;
    }
}
