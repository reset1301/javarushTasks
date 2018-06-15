package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("c:/111/1.a"));
        if (writer != null) {
            System.out.println(writer.toString());
        }
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter writer = new StringWriter();
        if (is != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String s = null;
            while ((s = reader.readLine()) != null) {
                writer.write(s);
            }
            reader.close();
        }
        return writer;
    }
}