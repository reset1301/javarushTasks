package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        String zipFileName = args[1];
        File file = new File(fileName);

        Map<String, ByteArrayOutputStream> archivedFiles = new HashMap<>();
        try (ZipInputStream zipReader = new ZipInputStream(new FileInputStream(zipFileName))) {
            ZipEntry entry;
            while ((entry = zipReader.getNextEntry()) != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int count = 0;
                while ((count = zipReader.read(buffer)) != -1)
                    byteArrayOutputStream.write(buffer, 0, count);

                archivedFiles.put(entry.getName(), byteArrayOutputStream);
            }
        }

        try (ZipOutputStream zipWriter = new ZipOutputStream(new FileOutputStream(zipFileName))) {
            for (Map.Entry<String, ByteArrayOutputStream> pair : archivedFiles.entrySet()) {
                if (pair.getKey().substring(pair.getKey().lastIndexOf("/") + 1).equals(file.getName())) continue;
                zipWriter.putNextEntry(new ZipEntry(pair.getKey()));
                zipWriter.write(pair.getValue().toByteArray());
            }

            ZipEntry zipEntry = new ZipEntry("new/" + file.getName());
            zipWriter.putNextEntry(zipEntry);
            Files.copy(file.toPath(), zipWriter);
        }
    }
}

// Работает, не принимает.
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        String fileName = args[0];
//        String pathToArchive = args[1];
//
//        ZipFile zipFile = new ZipFile(pathToArchive);
//        Path newFile = Paths.get(fileName);
//        Path tmpFile = Files.createTempFile(new SimpleDateFormat("YYYYddMMHHmmss").format(new Date()), ".tmp");
//        Path tmpZipFile = Files.createTempFile(new SimpleDateFormat("YYYYddMMHHmmss").format(new Date()), ".zip");
//
//        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(tmpZipFile.toFile()));
//        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(pathToArchive));
//        ZipEntry entry = null;
//        OutputStream outputStream = null;
//        while ((entry = zipInputStream.getNextEntry()) != null) {
//            System.out.println(entry.getName());
//            outputStream = new FileOutputStream(tmpFile.toFile(), false);
//            copyData(zipInputStream, outputStream);
//            outputStream.close();
//
//            zipOutputStream.putNextEntry(entry);
//            Files.copy(tmpFile, zipOutputStream);
//            zipOutputStream.closeEntry();
//        }
//        zipInputStream.close();
//
//        zipOutputStream.putNextEntry(new ZipEntry("new\\" + newFile.getFileName()));
//        Files.copy(newFile, zipOutputStream);
//        zipOutputStream.closeEntry();
//        zipOutputStream.close();
//
//        zipInputStream = new ZipInputStream(new FileInputStream(tmpZipFile.toFile()));
//        zipOutputStream = new ZipOutputStream(new FileOutputStream(pathToArchive, false));
//        while ((entry = zipInputStream.getNextEntry()) != null) {
//            zipOutputStream.putNextEntry(entry);
//            copyData(zipInputStream, zipOutputStream);
//            zipOutputStream.closeEntry();
//        }
//        zipInputStream.close();
//        zipOutputStream.close();
//    }
//
//    public static void copyData(ZipInputStream zipInputStream, OutputStream outputStream) throws IOException {
//        byte[] buf = new byte[1000];
//        int size;
//        while ((size = zipInputStream.read(buf)) > 0) {
//            outputStream.write(buf, 0, size);
//        }
//    }
//}
