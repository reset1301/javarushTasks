package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        while (br.ready()) {
            String[] s = br.readLine().split(" ");
//            int day=Integer.parseInt(s[s.length-3]);
            String day = (s[s.length - 3]);
//            int month=Integer.parseInt(s[s.length-2]);
            String month = (s[s.length - 2]);
//            int year=Integer.parseInt(s[s.length-1]);
            String year = (s[s.length - 1]);
            String name = "";
            for (int i = 0; i < s.length - 4; i++)
                name += s[i] + " ";
            name += s[s.length - 4];
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//            System.out.println(simpleDateFormat.parse("15/05/1985"));
//            Date date=new Date(new SimpleDateFormat("dd/MM/yyyy").parse(day + "/" + month + "/" + year)));
//            System.out.println(date);
            PEOPLE.add(new Person(name, simpleDateFormat.parse(day + "/" + month + "/" + year)));
        }
        br.close();
        for (int i = 0; i < PEOPLE.size(); i++)
            System.out.println(PEOPLE.get(i).getName()+" "+PEOPLE.get(i).getBirthday());
    }
}
