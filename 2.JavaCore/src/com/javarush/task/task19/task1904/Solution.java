package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.SimpleTimeZone;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws ParseException {
//        String[] s = "Иванов Иван Иванович 31 12 1950".split(" ");
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        Person person = new Person(s[1], s[2], s[0], simpleDateFormat.parse(s[3] + "/" + s[4] + "/" + s[5]));
//        System.out.println(person.toString());
//        for (String ss : s
//                ) {
//            System.out.println(ss);
//        }
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        @Override
        public Person read() throws IOException {
            String[] s = fileScanner.nextLine().split(" ");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Person person = null;
            try {
                person = new Person(s[1], s[2], s[0], simpleDateFormat.parse(s[3] + "/" + s[4] + "/" + s[5]));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }
    }
}
