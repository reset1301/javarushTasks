package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s1=bufferedReader.readLine();
        String s2=bufferedReader.readLine();
//        String s1 = "c:\\111\\aaa.111",s2="c:\\111\\aaa.222";
//        File f1 = new File(s1);
//        File f2 = new File(s2);
//        FileReader fr1 = new FileReader(f1);
//        FileReader fr2 = new FileReader(f2);
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(new File(s1)));
            String s3 = br1.readLine();
            while (s3 != null) {
                allLines.add(s3);
                s3 = br1.readLine();
            }
            BufferedReader br2 = new BufferedReader(new FileReader(new File(s2)));
            s3 = br2.readLine();
            while (s3 != null) {
                forRemoveLines.add(s3);
                s3 = br2.readLine();
            }
            br1.close();
            br2.close();
//        fr1.close();
//        fr2.close();
//        System.out.println(allLines);
//        System.out.println(forRemoveLines);
            Solution solution=new Solution();
            solution.joinData();
        }catch (CorruptedDataException e){
            e.printStackTrace();
        }
    }

    public void joinData() throws CorruptedDataException {
        boolean b=true;
        for (String rem:forRemoveLines
             ) {
            b=false;
            for (String all:allLines
                 ) {
                if (all.equals(rem)){
                    b=true;
                }
            }
            if (!b) break;
        }
//        System.out.println(b);
        if (b){
            for (String rem:forRemoveLines
                 ) {
                for (int i=0;i<allLines.size();i++){
                    if (allLines.get(i).equals(rem)){
                        allLines.remove(i);
                        i--;
                    }
                }
            }
        }
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
