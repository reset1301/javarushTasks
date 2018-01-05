package com.javarush.task.task13.task1319;

import java.io.*;
import java.nio.file.Paths;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new FileWriter(br.readLine()));
            String s = br.readLine();
            while(!s.equals("exit")) {
//                System.out.println(s);
                bw.write(s+System.lineSeparator());
                s = br.readLine();
            }
            bw.write(s+System.lineSeparator());
//            bw.close();
            br.close();
//        }
//        catch(Exception e){
//            System.out.println(e.getLocalizedMessage());
//        }
        bw.close();
    }
}
