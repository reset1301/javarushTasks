package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String in=br.readLine(),out=br.readLine();
        br.close();
        br=new BufferedReader(new FileReader(in));
        BufferedWriter bw=new BufferedWriter(new FileWriter(out));
        while (br.ready()){
            bw.write(br.readLine().replaceAll("\\.","!"));
        }
        br.close();
        bw.close();
    }
}
