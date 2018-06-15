package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException, URISyntaxException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("c:/111"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException, URISyntaxException {
        // implement this method
        URL url = new URL(urlString);
        SimpleDateFormat f = new SimpleDateFormat("YYYYddMMHHmmss");
        Path tempFile = Files.createTempFile(String.valueOf(f.format(new Date())), ".tmp");

        InputStream stream = url.openStream();
        Files.copy(stream, tempFile, REPLACE_EXISTING);
        if (Files.notExists(downloadDirectory))
            Files.createDirectories(downloadDirectory);
        Path target = Paths.get(downloadDirectory.toAbsolutePath().toString() +
                urlString.substring(urlString.lastIndexOf("/") ));
        Files.move(tempFile, target);
        return target;
    }
}
