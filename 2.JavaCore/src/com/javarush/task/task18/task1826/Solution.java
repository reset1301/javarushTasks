package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream f = new FileInputStream(args[1]);
        FileOutputStream fileOutputStream = new FileOutputStream(args[2]);
        if (args[0].equals("-e")){
            while (f.available()>0){
                fileOutputStream.write(f.read()+1);
            }
        }
        else if (args[0].equals("-d")){
            while (f.available()>0){
                fileOutputStream.write(f.read()-1);
            }
        }
        f.close();
        fileOutputStream.close();
    }

}
