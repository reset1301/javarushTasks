package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String resultFileName = args[0];

        FileOutputStream fos = new FileOutputStream(resultFileName);

        String[] fileNameParts = Arrays.stream(args).skip(1).sorted().toArray(String[]::new);

        Vector<InputStream> inputStreamVector = new Vector<>();

        for (String str: fileNameParts)
            inputStreamVector.add(new FileInputStream(str));

        try(ZipInputStream zipInputStream = new ZipInputStream(
                new SequenceInputStream(inputStreamVector.elements()))){

            ZipEntry entry = zipInputStream.getNextEntry(); // нужны ли эти две строки?

            streamTransfer(zipInputStream,fos);

            zipInputStream.closeEntry();           // не знаю, нужны ли эти две строки.
        }
        fos.close();
    }
    public static void streamTransfer(InputStream in, OutputStream out) throws IOException {
        byte[] buffer =new byte[1024];
        int countOfBytes;
        while ((countOfBytes = in.read(buffer))>0) {
            out.write(buffer, 0, countOfBytes);
            out.flush();
        }
    }

//    работает, но не принимается валидатором

//    public static void main(String[] args) throws IOException {
//        String resultFileName = args[0];
//        FileOutputStream fos = new FileOutputStream(resultFileName);
//        String[] fileNamePart = new String[args.length - 1];
//        for (int i = 1; i < args.length; i++) {
//            fileNamePart[i - 1] = args[i];
//        }
//
//        Arrays.sort(fileNamePart);
//
////        for (String s : fileNamePart) {
////            System.out.println(s);
////        }
//
//        Path tmpFile = Files.createTempFile(new SimpleDateFormat("YYYYMMDDHHmmss").format(new Date()), ".zip");
////        System.out.println(tmpFile.toAbsolutePath());
//
//        try (FileOutputStream fos1 = new FileOutputStream(tmpFile.toFile())) {
//            for (String filePart : fileNamePart) {
//                Path file = Paths.get(filePart);
////                System.out.println("Write file: " + file.toAbsolutePath());
//                try (FileInputStream is = new FileInputStream(file.toFile())) {
//                    byte[] buffer = new byte[1024];
//                    int count = 0;
//                    while ((count = is.read(buffer)) > 0) {
//                        fos1.write(buffer, 0, count);
//                    }
//                }
//            }
//        }
//
//        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(tmpFile.toFile()));
//        ) {
//            ZipEntry entry = null;
//            while ((entry = zis.getNextEntry()) != null) {
////                System.out.println("Unpack: " + entry.getName());
//                byte[] buffer = new byte[1024];
//                int count = 0;
//                while ((count = zis.read(buffer)) > 0) {
//                    fos.write(buffer, 0, count);
//                }
//                zis.closeEntry();
//            }
//        }
//        fos.close();
//    }
}
