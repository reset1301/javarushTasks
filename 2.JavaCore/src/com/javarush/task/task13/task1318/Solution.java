package com.javarush.task.task13.task1318;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String fName = br.readLine();
//        System.out.println(fName);
//        try {
            FileInputStream in = new FileInputStream(fName);
//            Scanner sc =new Scanner(Paths.get(fName));
            int i=0;
            while (in.available() > 0) {
//            while(sc.hasNext()){
//                System.out.println(sc.nextLine());
//                i=in.read();
                System.out.print((char) in.read());
//                i++;
            }
//            System.out.println("\n"+i);
//            sc.close();
            in.close();
            br.close();
//        }
//        catch(Exception e) {
//            System.out.println("File not found");
//        }

    }

}