package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        //напишите тут ваш код
//        ArrayList<Integer> a=new ArrayList<>();
//        a.add(6,4);
//        a[5] += 1;
//        double d = Double.parseDouble("red");
        Date date = new SimpleDateFormat("dd:MM").parse("12345");
//        int i = (int) new Object();
    }

    public static void main(String[] args)  {
//        new VeryComplexClass().veryComplexMethod();
    }
}
