package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.HashMap;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        HashMap<Integer, byte[]> hashMap=new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String s = "Lion.avi.part344";
//        System.out.println(s.indexOf("part"));
//        System.out.println(s.substring(0,s.indexOf("part")-1));
        String s=br.readLine();
        String nameOfFile = s.substring(0,s.indexOf("part")-1);
        while (!s.equals("end")){
            FileInputStream f = new FileInputStream(s);
            byte[]b=new byte[f.available()];
            f.read(b);
            hashMap.put(Integer.parseInt(s.substring(s.indexOf("part")+4)),b);
            s=br.readLine();
            f.close();
        }
        FileOutputStream f = new FileOutputStream(nameOfFile);
        for (int i=1;i<=hashMap.size();i++){
            f.write(hashMap.get(i));
        }
        f.close();

    }
}
