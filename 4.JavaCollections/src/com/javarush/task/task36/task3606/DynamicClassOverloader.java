package com.javarush.task.task36.task3606;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DynamicClassOverloader extends ClassLoader {
    File f;

    public DynamicClassOverloader(File f) {
        this.f = f;
    }

    protected Class findClass(String name) throws ClassNotFoundException {
        Class result;

        try {
            byte[] classBytes = loadFileAsBytes(f);
            result = defineClass(name, classBytes, 0, classBytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException("Cannot load class " + name + ": " + e);
        } catch (ClassFormatError e) {
            throw new ClassNotFoundException("Format of class file incorrect for class " + name + ": " + e);
        }

        return result;
    }

    public static byte[] loadFileAsBytes(File file) throws IOException {
        byte[] result = new byte[(int) file.length()];
        FileInputStream f = new FileInputStream(file);
        try {
            f.read(result, 0, result.length);
        } finally {
            try {
                f.close();
            } catch (Exception e) {
                // Игнорируем исключения, возникшие при вызове close. Они крайне маловероятны и не очень
                // важны - файл уже прочитан. Но если они все же возникнут, то они не должны замаскировать
                // действительно важные ошибки, возникшие при вызове read.
            }
            ;
        }
        return result;
    }
}
