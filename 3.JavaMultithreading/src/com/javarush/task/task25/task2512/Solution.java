package com.javarush.task.task25.task2512;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        List<Throwable> throwables = new LinkedList<>();
        Throwable th = e;
        while (th != null) {
            throwables.add(th);
            th = th.getCause();
        }
        for (int i = throwables.size() - 1; i >= 0; i--) {
            System.out.println(throwables.get(i));
        }
//        e.printStackTrace();
    }

    public static void main(String[] args) throws IOException {
//        Solution solution=new Solution();

//        new Solution().uncaughtException(Thread.currentThread(),new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));

//        -------------
//        For loadtesting create INN, KPP
        String nameFile = "c:\\111\\kpp_inn.dat";
        BufferedWriter bw = new BufferedWriter(new FileWriter(nameFile));
        bw.write("kpp,inn" + System.lineSeparator());
        int[] crc = {2, 4, 10, 3, 5, 9, 4, 6, 8};
        for (int i = 0; i <1000; i++) {
            int[] inn = {
                    (int) (Math.random() * 9),
                    (int) (Math.random() * 9),
                    (int) (Math.random() * 9),
                    (int) (Math.random() * 9),
                    (int) (Math.random() * 9),
                    (int) (Math.random() * 9),
                    (int) (Math.random() * 9),
                    (int) (Math.random() * 9),
                    (int) (Math.random() * 9),
                    0
            };
            inn[9] = (inn[0] * crc[0] + inn[1] * crc[1] + inn[2] * crc[2] + inn[3] * crc[3] + inn[4] * crc[4]
                    + inn[5] * crc[5] + inn[6] * crc[6] + inn[7] * crc[7] + inn[8] * crc[8]) % 11;
            if (inn[9] == 10)
                inn[9] = 0;
            int kpp = (int) (Math.random() * (1000000000 - 100000000) + 100000000);
//        System.out.println(kpp);
            bw.write(kpp + ",");
            for (int j : inn
                    ) {
//            System.out.print(i);
                bw.write(j+"");
            }
//        System.out.println();
            bw.write(System.lineSeparator());
        }
        bw.close();
//        ---------------------
    }
}
