package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException, InterruptedException {
        LinkedBlockingQueue<File> dirs = new LinkedBlockingQueue<>();
        List<String> files = new ArrayList<>();
        File file = new File(root);
        if (file.isDirectory()) {
            dirs.add(file);
        } else {
            files.add(file.getAbsolutePath());
            return files;
        }
        while (dirs.size() > 0) {
            file = dirs.poll();
            if (file.isDirectory()) {
                for (File f : file.listFiles()) {
                    if (f.isDirectory())
                        dirs.add(f);
                    else files.add(f.getAbsolutePath());
                }
            } else files.add(file.getAbsolutePath());
        }
        return files;

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        for (String s : getFileTree("c:\\111\\")) {
            System.out.println(s);
        }
    }
}
