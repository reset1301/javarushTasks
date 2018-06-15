package com.javarush.task.task36.task3606;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* 
Осваиваем ClassLoader и Reflection
*/
public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplse"));
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplf"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() {
        ClassLoader ourClassLoader = new ClassLoader() {
            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException {
                try (FileInputStream fis = new FileInputStream(name)) {
                    String className = name.substring(0, name.length() - 6);
                    byte[] bytes = new byte[fis.available()];
                    fis.read(bytes);

                    return defineClass(null, bytes, 0, bytes.length);
                } catch (IOException e) {
                    return super.findClass(name);
                }
            }
        };

        File clasDir = new File(packageName);
        String[] fileNames = clasDir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".class");
            }
        });

        for (String fileName : fileNames) {
            try {
                hiddenClasses.add(ourClassLoader.loadClass(packageName + clasDir.separator + fileName));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


    public HiddenClass getHiddenClassObjectByKey(String key) {
        for (Class clazz : hiddenClasses) {
            if (HiddenClass.class.isAssignableFrom(clazz)) {
                if (clazz.getSimpleName().toLowerCase().startsWith(key.toLowerCase())) {
                    try {
                        Constructor constructor = clazz.getDeclaredConstructor();
                        constructor.setAccessible(true);

                        return (HiddenClass) constructor.newInstance();
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return null;
    }
}

