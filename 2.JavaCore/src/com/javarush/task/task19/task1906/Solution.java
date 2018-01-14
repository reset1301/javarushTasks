package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine(), out = br.readLine();
        br.close();
        FileReader fileReader = new FileReader(in);
        FileWriter fileWriter = new FileWriter(out);
        boolean b = false;
        while (fileReader.ready()) {
            int x = fileReader.read();
            if (b)
                fileWriter.write(x);
            b = !b;
        }
        fileReader.close();
        fileWriter.close();
    }
}
