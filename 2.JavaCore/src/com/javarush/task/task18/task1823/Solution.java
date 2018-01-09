package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        while (!s.equals("exit")){
            ReadThread rt = new ReadThread(s);
            rt.start();
            s=br.readLine();
//            rt.interrupt();
        }
    }

    public static class ReadThread extends Thread {
        FileInputStream f;
        String fileName;
        HashMap<Integer,Integer>m;
        public ReadThread(String fileName) throws FileNotFoundException {
            //implement constructor body
            f = new FileInputStream(fileName);
            m=new HashMap<>();
            this.fileName=fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try {
                while (f.available() > 0) {
                    int a = f.read();
                    if (m.containsKey(a))
                        m.put(a,m.get(a)+1);
                    else m.put(a,1);
                }
                int max = 0, maxv=0;
                for (Map.Entry<Integer,Integer> mm:m.entrySet()
                     ) {
                    if (mm.getValue()>max){
                        max=mm.getValue();
                        maxv=mm.getKey();
                    }
                }
                resultMap.put(this.fileName,maxv);
//                this.interrupt();
                f.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
