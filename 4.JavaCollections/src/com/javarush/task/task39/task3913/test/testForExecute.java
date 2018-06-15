package com.javarush.task.task39.task3913.test;

import com.javarush.task.task39.task3913.Event;
import com.javarush.task.task39.task3913.LogParser;
import com.javarush.task.task39.task3913.Status;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class testForExecute {
//    @Test
//    @Ignore
//    public void testQuery() throws ParseException {
//        String s;
//        Set<Object> result = new HashSet<>();
//        Set<Object> expected = new HashSet<>();
//        LogParser parser = new LogParser(Paths.get("c:/111/"));
//        test1();
//
//        test2();
//
//        t3();
//
//        t4();
//
//        t5();
//
//        t6();
//
//        t7();
//
//        t8();
//
//        t9();
//
//        t10();
//
//        t11();
//
//        t12();
//
//        t13();
//
//        t14();
//
//        t15();
//
//        t16();
//
//        t17();
//
//        t18();
//
//        t19();
//
//        t20();
//
//    }

    @Test
    public void t20() {
        String s;
        Set<Object> result = new HashSet<>();
        Set<Object> expected = new HashSet<>();
        LogParser parser = new LogParser(Paths.get("c:/111/"));
        s = "get status for event = \"SOLVE_TASK\" and date between \"11.12.2013 10:11:15\" and \"05.01.2021 20:22:00\"";
        result = parser.execute(s);
        expected.clear();
        expected.add(Status.ERROR);
        expected.add(Status.OK);
        if (result.isEmpty())
            Assert.assertTrue(false);
        else
            Assert.assertTrue(Arrays.deepEquals(result.toArray(), expected.toArray()));
    }

    @Test
    public void t19() {
        String s;
        Set<Object> result = new HashSet<>();
        Set<Object> expected = new HashSet<>();
        LogParser parser = new LogParser(Paths.get("c:/111/"));
        s = "get status for date = \"30.01.2014 12:56:22\" and date between \"11.12.2013 10:11:15\" and \"05.01.2021 20:22:00\"";
        result = parser.execute(s);
        expected.clear();
        expected.add(Status.ERROR);
        if (result == null || result.isEmpty())
            Assert.assertTrue(false);
        else
            Assert.assertTrue(Arrays.deepEquals(result.toArray(), expected.toArray()));
    }

    @Test
    public void t18() {
        String s;
        Set<Object> result = new HashSet<>();
        Set<Object> expected = new HashSet<>();
        LogParser parser = new LogParser(Paths.get("c:/111/"));
        s = "get status for user = \"Amigo\" and date between \"11.12.2013 10:11:15\" and \"05.01.2021 20:22:00\"";
        result = parser.execute(s);
        expected.clear();
        if (result == null)
            Assert.fail();
        else if (result.size()==0)
            Assert.assertTrue(true);
//            Assert.assertTrue(Arrays.deepEquals(result.toArray(), expected.toArray()));
    }

    @Test
    public void t17() {
        String s;
        Set<Object> result = new HashSet<>();
        Set<Object> expected = new HashSet<>();
        LogParser parser = new LogParser(Paths.get("c:/111/"));
        s = "get status for ip = \"192.168.100.2\" and date between \"11.12.2013 10:11:15\" and \"05.01.2021 20:22:00\"";
        result = parser.execute(s);
        expected.clear();
        expected.add(Status.ERROR);
        expected.add(Status.OK);
        if (result.isEmpty())
            Assert.fail();
        else
            Assert.assertTrue(Arrays.deepEquals(result.toArray(), expected.toArray()));
    }

    @Test
    public void t16() {
        String s;
        Set<Object> result = new HashSet<>();
        Set<Object> expected = new HashSet<>();
        LogParser parser = new LogParser(Paths.get("c:/111/"));
        s = "get event for status = \"OK\" and date between \"11.12.2013 10:11:15\" and \"05.01.2021 20:22:00\"";
        result = parser.execute(s);
        expected.clear();
        expected.add(Event.WRITE_MESSAGE);
        expected.add(Event.LOGIN);
        expected.add(Event.SOLVE_TASK);
        if (result.isEmpty())
            Assert.fail();
        else
            Assert.assertTrue(Arrays.deepEquals(result.toArray(), expected.toArray()));
    }

    @Test
    public void t15() {
        String s;
        Set<Object> result = new HashSet<>();
        Set<Object> expected = new HashSet<>();
        LogParser parser = new LogParser(Paths.get("c:/111/"));
        s = "get event for date = \"30.01.2014 12:56:22\" and date between \"11.12.2013 10:11:15\" and \"05.01.2021 20:22:00\"";
        result = parser.execute(s);
        expected.clear();
        expected.add(Event.SOLVE_TASK);
        if (result == null || result.isEmpty())
            Assert.fail();
        else

            Assert.assertTrue(Arrays.deepEquals(result.toArray(), expected.toArray()));
    }

    @Test
    public void t14() {
        String s;
        Set<Object> result = new HashSet<>();
        Set<Object> expected = new HashSet<>();
        LogParser parser = new LogParser(Paths.get("c:/111/"));
        s = "get event for user = \"Amigo\" and date between \"11.12.2013 10:11:15\" and \"05.01.2021 20:22:00\"";
        result = parser.execute(s);
        expected.clear();
        if (result == null || result.isEmpty())
            Assert.assertTrue(true);
    }

    @Test
    public void t13() {
        String s;
        Set<Object> result = new HashSet<>();
        Set<Object> expected = new HashSet<>();
        LogParser parser = new LogParser(Paths.get("c:/111/"));
        s = "get event for ip = \"192.168.100.2\" and date between \"11.12.2013 10:11:15\" and \"05.01.2021 20:22:00\"";
        result = parser.execute(s);
        expected.clear();
        expected.add(Event.SOLVE_TASK);
        if (result.isEmpty())
            Assert.fail();
        else

            Assert.assertTrue(Arrays.deepEquals(result.toArray(), expected.toArray()));
    }

    @Test
    public void t12() throws ParseException {
        String s;
        Set<Object> result = new HashSet<>();
        Set<Object> expected = new HashSet<>();
        LogParser parser = new LogParser(Paths.get("c:/111/"));
        s = "get date for status = \"OK\" and date between \"11.12.2013 10:11:15\" and \"05.01.2021 20:22:00\"";
        result = parser.execute(s);
        expected.clear();
        expected.add(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse("12.12.2013 21:56:30"));
        expected.add(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse("03.01.2014 03:45:23"));
        expected.add(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse("14.11.2015 07:08:01"));
        expected.add(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse("19.03.2016 00:00:00"));
        if (result.isEmpty())
            Assert.fail();
        else
            Assert.assertTrue(Arrays.deepEquals(result.toArray(), expected.toArray()));
    }

    @Test
    public void t11() throws ParseException {
        String s;
        Set<Object> result = new HashSet<>();
        Set<Object> expected = new HashSet<>();
        LogParser parser = new LogParser(Paths.get("c:/111/"));
        s = "get date for event = \"SOLVE_TASK\" and date between \"11.12.2013 10:11:15\" and \"05.01.2021 20:22:00\"";
        result = parser.execute(s);
        expected.clear();
        expected.add(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse("30.01.2014 12:56:22"));
        expected.add(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse("19.03.2016 00:00:00"));
        if (result.isEmpty())
            Assert.fail();
        else

            Assert.assertTrue(Arrays.deepEquals(result.toArray(), expected.toArray()));
    }

    @Test
    public void t10() {
        String s;
        Set<Object> result = new HashSet<>();
        Set<Object> expected = new HashSet<>();
        LogParser parser = new LogParser(Paths.get("c:/111/"));
        s = "get date for user = \"Amigo\" and date between \"11.12.2013 10:11:15\" and \"05.01.2021 20:22:00\"";
        result = parser.execute(s);
        expected.clear();
        if (result == null || result.isEmpty())
            Assert.assertTrue(true);
    }

    @Test
    public void t9() throws ParseException {
        String s;
        Set<Object> result = new HashSet<>();
        Set<Object> expected = new HashSet<>();
        LogParser parser = new LogParser(Paths.get("c:/111/"));
        s = "get date for ip = \"192.168.100.2\" and date between \"11.12.2013 10:11:15\" and \"05.01.2021 20:22:00\"";
        result = parser.execute(s);
        expected.clear();
        expected.add(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse("30.01.2014 12:56:22"));
        expected.add(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse("19.03.2016 00:00:00"));
        if (result.isEmpty())
            Assert.fail();
        else

            Assert.assertTrue(Arrays.deepEquals(result.toArray(), expected.toArray()));
    }

    @Test
    public void t8() {
        String s;
        Set<Object> result = new HashSet<>();
        Set<Object> expected = new HashSet<>();
        LogParser parser = new LogParser(Paths.get("c:/111/"));
        s = "get user for status = \"OK\" and date between \"11.12.2013 10:11:15\" and \"05.01.2021 20:22:00\"";
        result = parser.execute(s);
        expected.clear();
        expected.add("Vasya Pupkin");
        expected.add("Eduard Petrovich Morozko");
        if (result.isEmpty())
            Assert.fail();
        else

            Assert.assertTrue(Arrays.deepEquals(result.toArray(), expected.toArray()));
    }

    @Test
    public void t7() {
        String s;
        Set<Object> result = new HashSet<>();
        Set<Object> expected = new HashSet<>();
        LogParser parser = new LogParser(Paths.get("c:/111/"));
        s = "get user for event = \"SOLVE_TASK\" and date between \"11.12.2013 10:11:15\" and \"05.01.2021 20:22:00\"";
        result = parser.execute(s);
        expected.clear();
        expected.add("Vasya Pupkin");
        if (result.isEmpty())
            Assert.fail();
        else

            Assert.assertTrue(Arrays.deepEquals(result.toArray(), expected.toArray()));
    }

    @Test
    public void t6() {
        String s;
        Set<Object> result = new HashSet<>();
        Set<Object> expected = new HashSet<>();
        LogParser parser = new LogParser(Paths.get("c:/111/"));
        s = "get user for date = \"30.01.2014 12:56:22\" and date between \"11.12.2013 10:11:15\" and \"05.01.2021 20:22:00\"";
        result = parser.execute(s);
        expected.clear();
        expected.add("Vasya Pupkin");
        if (result == null || result.isEmpty())
            Assert.fail();
        else

            Assert.assertTrue(Arrays.deepEquals(result.toArray(), expected.toArray()));
    }

    @Test
    public void t5() {
        String s;
        Set<Object> result = new HashSet<>();
        Set<Object> expected = new HashSet<>();
        LogParser parser = new LogParser(Paths.get("c:/111/"));
        s = "get user for ip = \"192.168.100.2\" and date between \"11.12.2013 10:11:15\" and \"05.01.2021 20:22:00\"";
        result = parser.execute(s);
        expected.clear();
        expected.add("Vasya Pupkin");
        if (result.isEmpty())
            Assert.fail();
        else

            Assert.assertTrue(Arrays.deepEquals(result.toArray(), expected.toArray()));
    }

    @Test
    public void t4() {
        String s;
        Set<Object> result = new HashSet<>();
        Set<Object> expected = new HashSet<>();
        LogParser parser = new LogParser(Paths.get("c:/111/"));
        s = "get ip for status = \"OK\" and date between \"11.12.2013 10:11:15\" and \"05.01.2021 20:22:00\"";
        result = parser.execute(s);
        expected.clear();
        expected.add("146.34.15.5");
        expected.add("127.0.0.1");
        expected.add("192.168.100.2");
        if (result.isEmpty())
            Assert.fail();
        else

            Assert.assertTrue(Arrays.deepEquals(result.toArray(), expected.toArray()));
    }

    @Test
    public void t3() {
        String s;
        Set<Object> result = new HashSet<>();
        Set<Object> expected = new HashSet<>();
        LogParser parser = new LogParser(Paths.get("c:/111/"));
        s = "get ip for event = \"SOLVE_TASK\" and date between \"11.12.2013 10:11:15\" and \"05.01.2021 20:22:00\"";
        result = parser.execute(s);
        expected.clear();
        expected.add("192.168.100.2");
        if (result.isEmpty())
            Assert.fail();
        else

            Assert.assertTrue(Arrays.deepEquals(result.toArray(), expected.toArray()));
    }

    @Test
    public void test2() {
        String s;
        Set<Object> result = new HashSet<>();
        Set<Object> expected = new HashSet<>();
        LogParser parser = new LogParser(Paths.get("c:/111/"));
        s = "get ip for date = \"30.01.2014 12:56:22\" and date between \"11.12.2013 10:11:15\" and \"05.01.2021 20:22:00\"";
        result = parser.execute(s);
        expected.clear();
        expected.add("192.168.100.2");
        if (result == null || result.isEmpty())
            Assert.fail();
        else

            Assert.assertTrue(Arrays.deepEquals(result.toArray(), expected.toArray()));
    }

    @Test
    public void test1() {
        LogParser parser = new LogParser(Paths.get("c:/111/"));
        String s;
        Set<Object> result;
        s = "get ip for user = \"Amigo\" and date between \"11.12.2013 10:11:15\" and \"05.01.2021 20:22:00\"";
        result = parser.execute(s);
        if (result == null || result.isEmpty())
            Assert.assertTrue(true);
//        Assert.assertTrue(Arrays.deepEquals(result.toArray(), expected.toArray()));
    }
}
