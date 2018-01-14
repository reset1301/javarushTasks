package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
//        String s = "+38(050)123-45-67";
//        System.out.println(s.replace("(","").replace(")","").replace("-",""));
    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.contact = contact;
            this.customer = customer;
        }

        @Override
        public String getCountryCode() {
            String key = "";
            for (Map.Entry<String, String> m : countries.entrySet()
                    ) {
                if (m.getValue().equals(customer.getCountryName()))
                    key = m.getKey();
            }
            return key;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String[] s=contact.getName().split(", ");
            return s[1];
        }

        @Override
        public String getContactLastName() {
            String[] s=contact.getName().split(", ");
            return s[0];
        }

        @Override
        public String getDialString() {
            return "callto://"+contact.getPhoneNumber().replace("(","").replace(")","").replace("-","");
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}