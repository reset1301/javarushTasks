package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<FileInputStream>ff=new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        try {
            s = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            while (true) {
                ff.add(new FileInputStream(s));
                s=br.readLine();
            }
        }catch (FileNotFoundException e){
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (FileInputStream f:ff
             ) {
            f.close();
        }
    }
}
