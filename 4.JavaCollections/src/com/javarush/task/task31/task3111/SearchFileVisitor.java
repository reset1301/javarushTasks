package com.javarush.task.task31.task3111;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName, partOfContent;
    private int minSize, maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        long fileSize = Files.size(file);

        if (maxSize == 0) {
            maxSize = Integer.MAX_VALUE;
        }

        if (fileSize < minSize || fileSize > maxSize) {
            return super.visitFile(file, attrs);
        }

        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        String contentString = new String(content);

        if (partOfName != null && !partOfName.equals("") && !file.getFileName().toString().contains(partOfName)) {
            return super.visitFile(file, attrs);
        }

        if (partOfContent != null && !partOfContent.equals("") && !contentString.contains(partOfContent)) {
            return super.visitFile(file, attrs);
        }

        foundFiles.add(file);
        return super.visitFile(file, attrs);
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
}
