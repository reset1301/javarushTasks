package com.javarush.task.task01.task0101;

/* 
Круто быть программистом!
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution {
    public static void main(String[] args) throws ParseException {
        //напишите тут ваш код
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = simpleDateFormat.parse("26.03.2018");
        System.out.println(date.getTime()/1000);
    }
}
