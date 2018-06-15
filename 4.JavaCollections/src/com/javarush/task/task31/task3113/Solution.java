package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Stream;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
//            Path path = Paths.get("c:/111");
            Path path = Paths.get(reader.readLine());
            if (!Files.isDirectory(path)) {
                System.out.println(path.toAbsolutePath().toString() + " - не папка");
                return;
            }
            long pathSize = 0;
            int filesCount = 0, dirsCount = -1;

            Stream<Path> stream = Files.walk(path, FileVisitOption.FOLLOW_LINKS);
            Iterator<Path> iterator = stream.iterator();
            while (iterator.hasNext()) {
                path = iterator.next();
                if (Files.isDirectory(path))
                    dirsCount++;
                else {
                    filesCount++;
                    pathSize += Files.size(path);
                }
            }

            System.out.println("Всего папок - " + dirsCount);
            System.out.println("Всего файлов - " + filesCount);
            System.out.println("Общий размер - " + pathSize);
        }
    }
}
