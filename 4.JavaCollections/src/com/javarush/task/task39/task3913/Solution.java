package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws ParseException {
//        LogParser logParser = new LogParser(Paths.get("c:/logs/"));
//        Set<String> stringSet = new HashSet<>();
//        stringSet.add("a");
//        stringSet.add("b");
//        stringSet.add("a");
//        stringSet.add("a");
//        System.out.println(stringSet.size());
//        Set<Date> dateSet = new HashSet<>();
//        dateSet.add(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse("30.08.2012 16:08:13"));
//        dateSet.add(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse("30.08.2012 16:08:40"));
//        dateSet.add(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse("13.09.2013 5:04:50"));
//        Date[] dates = new Date[dateSet.size()];
//        int ii = 0;
//        for (Date d : dateSet) {
//            dates[ii++] = d;
//        }
//        Arrays.sort(dates);
//        for (Date d : dateSet) {
//            System.out.println(d);
//        }
//        System.out.println("------------");
//        for (int i = 0; i < dates.length; i++) {
//            System.out.println(dates[i]);
//        }
////        System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));
//        Event event = Event.DONE_TASK;
//        System.out.println("DONE_TASK".equals(event.toString()));
        LogParser parser = new LogParser(Paths.get("c:/111/"));
//        Set<Object> set = parser.execute("get ip for user = \"Amigo\"");
//        Set<Object> set = parser.execute("get user for event = \"LOGIN\"");
//        Set<Object> set = parser.execute("get date for event = \"LOGIN\"");
//        Set<Object> set = parser.execute("get date for event = \"LOGIN\"");
//        Set<Object> set = parser.execute("get status for date = \"14.10.2021 11:38:21\"");
//        Set<Object> set = parser.execute("get ip for user = \"Amigo\"");
//        Set<Object> set = parser.execute("get ip for user = \"Amigo\"");
//        Set<Object> set = parser.execute("get ip for user = \"Amigo\"");
//        Set<Object> set = parser.execute("get user");
//        Set<Object> set = parser.execute("get date");
//        Set<Object> set = parser.execute("get event");
//        Set<Object> set = parser.execute("get status for event = \"SOLVE_TASK\"");
//        String query = "get status for date = \"30.01.2014 12:56:22\" and date between \"11.12.2013 10:11:15\" and \"05.01.2021 20:22:00\"";
//        String[] value = query.split(" ");
        String query = "get status for user = \"Amigo\" and date between \"11.12.2013 10:11:15\" and \"05.01.2021 20:22:00\"";
        String[] value = query.split(" ");
//        String value2 = query.substring(query.indexOf("\"") + 1);
        ArrayList<Integer> arrayList = new ArrayList<>(query.length());
        int count = 0;
        for (int i = 0; i < value.length; i++) {
            if (value[i].contains("\"")) count++;
//            arrayList.add(i, value[i].contains("\"") ? 1 : 0);
//            System.out.print(arrayList.get(i) +" ");
        }
        System.out.println(count);
        String value2="";
        String befStr = "";
        String afStr="";
        if (count == 5) {
            value2 = query.split(" ")[5].substring(1, query.split(" ")[5].length() - 1);
            afStr = query.split(" ")[9].substring(1) + " " + query.split(" ")[10].substring(0, query.split(" ")[10].length() - 1);
            befStr = query.split(" ")[12].substring(1) + " " + query.split(" ")[13].substring(0, query.split(" ")[13].length() - 1);
        } else {
            value2 = query.split(" ")[5].substring(1) + " " + query.split(" ")[6].substring(0, query.split(" ")[6].length() - 1);
            afStr = query.split(" ")[10].substring(1) + " " + query.split(" ")[11].substring(0, query.split(" ")[11].length() - 1);
            befStr = query.split(" ")[13].substring(1) + " " + query.split(" ")[14].substring(0, query.split(" ")[14].length() - 1);
        }
        System.out.println(befStr);
//        String value = value2.substring(0, query.indexOf("\"") - 3);
//        String afStr = query.substring(query.indexOf("\"") + 1).substring(query.indexOf("\"") - 2).substring(query.indexOf("\"") - 3).substring(0, query.indexOf("\"") - 3);
//        after = after.substring(query.indexOf("\"") - 2).substring(query.indexOf("\"") - 3).substring(0, query.indexOf("\"") - 3);
//        after = after.substring(query.indexOf("\"") - 3);
//        after = after.substring(0, query.indexOf("\"")-3);
//        String befStr = query.
//                substring(query.indexOf("\"") + 1, query.lastIndexOf("\"")).
//                substring(query.indexOf("\"")).
//                substring(query.indexOf("\"")).
//                substring(query.indexOf("\"") - 1);
//        before = before.substring(query.indexOf("\""));
//        before = before.substring(query.indexOf("\""));
//        before = before.substring(query.indexOf("\"") - 1);
//        value2 = value2.substring(0, query.indexOf("\""));

        Set<Object> set = parser.execute
                (query);
        for (Object o : set) {
            System.out.println(o);
        }
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
//        Date before = dateFormat.parse("29.03.2021 00:00:00");
//        Date after = dateFormat.parse("29.03.2016 00:00:00");
//        System.out.println("null, null:");
//        parser.getNumberOfUniqueIPs(null, null);
//        parser.getIPsForUser("Amigo", null, null);
//        parser.getIPsForEvent(Event.DONE_TASK, null, null);
//        System.out.println("\nafter, null:");
//        parser.getNumberOfUniqueIPs(after, null);
//        parser.getIPsForUser("Amigo", after, null);
//        parser.getIPsForEvent(Event.DONE_TASK, after, null);
//        System.out.println("\nnull, before:");
//        parser.getNumberOfUniqueIPs(null, before);
//        parser.getIPsForUser("Amigo", null, before);
//        parser.getIPsForEvent(Event.DONE_TASK, null, before);
//        System.out.println("\nafter, before:");
//        parser.getNumberOfUniqueIPs(after, before);
//        parser.getIPsForEvent(Event.DONE_TASK, after, before);
//        parser.getIPsForUser("Amigo", after, before);
    }
}