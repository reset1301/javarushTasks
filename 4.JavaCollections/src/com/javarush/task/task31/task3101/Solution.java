package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<File> list = new ArrayList<File>();
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File newFileName = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        if (FileUtils.isExist(newFileName))
            FileUtils.deleteFile(newFileName);
        FileUtils.renameFile(resultFileAbsolutePath,newFileName);
        BufferedWriter writer = new BufferedWriter(new FileWriter(newFileName));
        for (File file:searchFiles(path, list)) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while (reader.ready()){
                writer.write(reader.readLine());
            }
            writer.newLine();
            reader.close();
        }
        writer.close();
    }
    static public ArrayList<File> searchFiles(File folder, ArrayList<File> list)
    {
        File[] folderEntries = folder.listFiles();
        for (File entry : folderEntries)
        {
            if (entry.isDirectory())
            {
                searchFiles(entry, list);
            }
            else if(entry.isFile()){
                if(entry.length()>50){
                    FileUtils.deleteFile(entry);
                }else{
                    list.add(entry);
                }
            }
        }
        Collections.sort(list, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                String fileName1 = o1.getName();
                String fileName2 = o2.getName();
                return fileName1.compareTo(fileName2);
            }
        });
        return list;
    }

}
//        String pathString = args[0];//"c:\\111\\tmp";
//        String resultFileAbsolutePathString = args[1];//"c:\\111\\1.a";
//        File path = new File(pathString);
//        File resultFileAbsolutePath = new File(resultFileAbsolutePathString);
//        List<String> files = new ArrayList<>();
//        File file1 = new File(resultFileAbsolutePath.getParent() + "/" + "allFilesContent.txt");
//        if (FileUtils.isExist(file1))
//            FileUtils.deleteFile(file1);
//        FileUtils.renameFile(resultFileAbsolutePath, file1);
//        resultFileAbsolutePath = file1;
//
//        for (File file : path.listFiles()) {
//            if (file.length() <= 50) {
//                files.add(file.getName());
//            }
//        }
//        files.sort(String.CASE_INSENSITIVE_ORDER);
////        for (String file : files) {
////            System.out.println(file);
////        }
////        System.out.println("*** " + path.getAbsolutePath());
////        System.out.println();
//
//        try (FileWriter writer = new FileWriter(resultFileAbsolutePath, true)) {
//            for (String fileName : files) {
//                File file = new File(path.getAbsolutePath() + "/" + fileName);
//                try (FileReader reader = new FileReader(file)) {
//                    //                    System.out.println(file.getAbsolutePath());
//                    while (reader.ready())
//                        writer.write(reader.read());
//                    writer.write("\n");
////                    reader.close();
////                        }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
////                writer.close();
////            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
