package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
//Работает. Не принимает.
//public class Solution {
//    public static void main(String[] args) {
//        String[] s = "{name=Ivanov, country=Ukraine, city=Kiev, age=null}".
//                replace("{", "").
//                replace("}", "").
//                split(",");
//        Map<String, String> map = new LinkedHashMap<>();
//        for (String ss : s
//                ) {
//            String[] sss = ss.trim().split("=");
//            if (sss.length == 2)
//                map.put(sss[0], sss[1]);
//            else if (sss.length == 1)
//                map.put(sss[0], "null");
//            else map.put("null", "null");
//        }
////        StringBuilder s1 = new StringBuilder(s);
//        System.out.println(getQuery(map));
//        getQuery(map);
//
//    }
//
//    private static String getQuery(Map<String, String> params) {
//        StringBuilder stringBuilder = new StringBuilder();
////        if (params != null)
//            for (Map.Entry<String, String> m : params.entrySet()
//                    ) {
//                if (!m.getValue().equals("null")
//                        ){
////                        && (!m.getKey().equals("null"))) {
//                    if (stringBuilder.length() != 0)
//                        stringBuilder.append(" and ");
//                    stringBuilder.append(m.getKey());
//                    stringBuilder.append("='");
//                    stringBuilder.append(m.getValue());
//                    stringBuilder.append("'");
//                }
//            }
//        return stringBuilder.toString().trim();
//    }
public class Solution {

    public static void main(String[] args) {

        Map<String, String> map = new LinkedHashMap<>();

        map.put("name","Ivanov");

        map.put("country","Ukraine");

        map.put("city","Kiev");

        map.put("age",null);

        map.put("name1","Ivanov");

        map.put("name2","Ivanov");



        System.out.println(getQuery(map));

    }



    public static String getQuery(Map<String, String> params) {

        StringBuilder result = new StringBuilder();

        if (params == null || params.isEmpty())

            return result.toString();



        for (Map.Entry<String, String> pair : params.entrySet()) {

            if (pair.getKey() == null || pair.getValue() == null)

                continue;



            result.append(pair.getKey()).append(" = '").append(pair.getValue()).append("' and ");

        }



        if (result.length() > 5)

            result.delete(result.length() - 5, result.length());



        return result.toString();

    }
}
