package com.javarush.task.task31.task3113;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private int dirsCount = 0, filesCount = 0;
    private long pathSize;

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        long fileSize = Files.size(file);

        if (Files.isDirectory(file))
            dirsCount++;
        else filesCount++;

        return super.visitFile(file, attrs);
    }

    public int getDirsCount() {
        return dirsCount;
    }

    public int getFilesCount() {
        return filesCount;
    }
}
