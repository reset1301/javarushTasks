package com.javarush.task.task32.task3213;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        StringWriter writer = new StringWriter();
        if (reader != null) {
            char[] c = new char[1];
            int len = 0;
            while ((len = reader.read(c)) > 0) {
                writer.write((char) ((byte) c[0] + key));
            }
        }
        return writer.toString();
    }
}
