package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception {
        //start here - начни тут
        Date d=new Date();
        SimpleDateFormat ss = new SimpleDateFormat("dd/MM/yyyy");
        switch (args[0]){
            case ("-c"): {
                synchronized (allPeople) {
                    int i = 1;
                    while (i < args.length) {
//                        d.setYear(Integer.parseInt(args[i + 2].substring(6)) - 1900);
//                        d.setMonth(Integer.parseInt(args[i + 2].substring(3, 5)) - 1);
//                        d.setDate(Integer.parseInt(args[i + 2].substring(0, 2)));
                        if (args[i + 1].equals("м"))
                            allPeople.add(Person.createMale(args[i], ss.parse(args[i+2])));
                        else
                            allPeople.add(Person.createFemale(args[i], ss.parse(args[i+2])));
                        i += 3;
                        System.out.println(allPeople.size() - 1);
                    }
                }
                break;
            }

            case ("-u"):{
                synchronized (allPeople) {
                    int i = 1;
                    while (i < args.length) {
//                        d.setYear(Integer.parseInt(args[i + 3].substring(6)) - 1900);
//                        d.setMonth(Integer.parseInt(args[i + 3].substring(3, 5)) - 1);
//                        d.setDate(Integer.parseInt(args[i + 3].substring(0, 2)));
                        if (args[i + 2].equals("м"))
                            allPeople.set(Integer.parseInt(args[i]), Person.createMale(args[i + 1], ss.parse(args[i+3])));
                        else
                            allPeople.set(Integer.parseInt(args[i]), Person.createFemale(args[i + 1], ss.parse(args[i+3])));
                        i += 4;
                    }
                }
                break;
            }

            case ("-d"):{
                synchronized (allPeople) {
                    int i = 1;
                    while (i < args.length) {
                        allPeople.get(Integer.parseInt(args[i])).setName(null);
                        allPeople.get(Integer.parseInt(args[i])).setBirthDay(null);
                        allPeople.get(Integer.parseInt(args[i])).setSex(null);
                        i++;
                    }
                }
                break;
            }

            case ("-i"):{
                synchronized (allPeople) {
                    int i = 1;
                    while (i < args.length) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                        System.out.println(allPeople.get(Integer.parseInt(args[i])).getName() + " " +
                                ((allPeople.get(Integer.parseInt(args[i])).getSex().equals(Sex.MALE)) ? "м" : "ж") + " " +
                                simpleDateFormat.format(allPeople.get(Integer.parseInt(args[i])).getBirthDay())
                        );
                        i++;
                    }
                }
            }
        }
    }
}
