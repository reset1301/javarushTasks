package com.javarush.task.task17.task1710;

import org.omg.PortableInterceptor.INACTIVE;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
//        System.out.println("25/04/1985".substring(6)+"-"+"25/04/1985".substring(3,5)+"-"+"25/04/1985".substring(0,2));
//        String s="25/04/1985",s1=s.substring(6),s2=s.substring(3,5),s3=s.substring(0,2);
        Date d=new Date();
//        d.setYear(Integer.parseInt(s.substring(6))-1900);
//        d.setMonth(Integer.parseInt(s2)-1);
//        d.setDate(Integer.parseInt(s3));
//        System.out.println(d);
//        SimpleDateFormat ss=new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
//        System.out.println(ss.format(d));
        if (args[0].equals("-c")&&args.length>=4){
            d.setYear(Integer.parseInt(args[3].substring(6))-1900);
            d.setMonth(Integer.parseInt(args[3].substring(3,5))-1);
            d.setDate(Integer.parseInt(args[3].substring(0,2)));
            if (args[2].equals("м"))
                allPeople.add(Person.createMale(args[1],d));
            else
                allPeople.add(Person.createFemale(args[1],d));
            for (int i=0;i<allPeople.size();i++) {
                if (allPeople.get(i).getName().equals(args[1])&&allPeople.get(i).getBirthDay().equals(d))
                    System.out.println(i);
            }
        }

        else if (args[0].equals("-u")&&args.length>=5){
            d.setYear(Integer.parseInt(args[4].substring(6))-1900);
            d.setMonth(Integer.parseInt(args[4].substring(3,5))-1);
            d.setDate(Integer.parseInt(args[4].substring(0,2)));

            if (args[2].equals("м"))
                allPeople.set(Integer.parseInt(args[1]),Person.createMale(args[2],d));
            else
                allPeople.set(Integer.parseInt(args[1]),Person.createFemale(args[2],d));
        }

        else if (args[0].equals("-d")&&args.length>=2){
            allPeople.get(Integer.parseInt(args[1])).setName(null);
            allPeople.get(Integer.parseInt(args[1])).setBirthDay(null);
            allPeople.get(Integer.parseInt(args[1])).setSex(null);
        }
        else if (args[0].equals("-i")&&args.length>=2){
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);
            System.out.println(allPeople.get(Integer.parseInt(args[1])).getName()+" "+
                    ((allPeople.get(Integer.parseInt(args[1])).getSex().equals(Sex.MALE))?"м":"ж")+" "+
                    simpleDateFormat.format(allPeople.get(Integer.parseInt(args[1])).getBirthDay())
                    );
        }
    }
}
