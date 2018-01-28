package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = br.readLine();
        br.close();
        FileInputStream fileInputStream = new FileInputStream(nameFile);
        this.load(fileInputStream);
        fileInputStream.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
//        PrintWriter printWriter = new PrintWriter(outputStream);
        Properties properties1 = new Properties();
        for (Map.Entry<String, String> m : properties.entrySet()
                ) {
//            printWriter.write(m.getKey() + "=" + m.getValue());
            properties1.put(m.getKey(), m.getValue());
        }
        properties1.save(outputStream,null);
//        printWriter.flush();
//        printWriter.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties properties1 = new Properties();
        properties1.load(inputStream);
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//        while (bufferedReader.ready()) {
//            String[] s = bufferedReader.readLine().split("=");
//            properties.put(s[0], s[1]);
//        }
        for (Map.Entry<Object, Object> m:properties1.entrySet()
             ) {
            properties.put(m.getKey().toString(), m.getValue().toString());
        }
//        bufferedReader.close();
    }

    public static void main(String[] args) {

    }
}
