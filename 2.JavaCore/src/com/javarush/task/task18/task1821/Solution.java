package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream f1 = new FileInputStream(args[0]);
        HashMap<Character,Integer>map=new HashMap<>();
        while (f1.available()>0){
            char c =(char)f1.read();
            if (map.containsKey(c))
                map.put(c,map.get(c)+1);
            else map.put(c,1);
        }
        char[] cc = new char[map.size()];
        int i=0;
        for (Map.Entry<Character,Integer>m:map.entrySet()){
            cc[i]=m.getKey();
            i++;
        }
        for (int j=0;j<cc.length;j++)
            for (int k=0;k<cc.length-1;k++)
                if ((int)cc[k]>(int)cc[k+1]){
                    char bb=cc[k];
                    cc[k]=cc[k+1];
                    cc[k+1]=bb;
                }
        for (int j=0;j<cc.length;j++)
            System.out.println(cc[j]+" "+map.get(cc[j]));
//        for (Map.Entry<Character,Integer>m:map.entrySet()
//             ) {
//            System.out.println(m.getKey()+" "+m.getValue());
//        }
        f1.close();
    }
}
