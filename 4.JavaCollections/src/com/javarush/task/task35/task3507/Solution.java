package com.javarush.task.task35.task3507;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

/* ClassLoader - что это такое?
Реализуйте логику метода getAllAnimals.
Аргумент метода pathToAnimals - это абсолютный путь к директории, в которой хранятся скомпилированные классы.
Путь не обязательно содержит / в конце.
НЕ все классы наследуются от интерфейса Animal.
НЕ все классы имеют публичный конструктор без параметров.
Только для классов, которые наследуются от Animal и имеют публичный конструктор без параметров, - создать по одному объекту.
Добавить созданные объекты в результирующий сет и вернуть.
Метод main не участвует в тестировании.
*/

public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals =
                getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath().substring(1)
                        + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<Animal> result = new HashSet<>();
        if (!pathToAnimals.endsWith("\\") && !pathToAnimals.endsWith("/"))
            pathToAnimals = pathToAnimals + "/";
        File dir = new File(pathToAnimals);

        String[] modules = dir.list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".class");
            }
        });

        for (String m : modules) {
            try {
                final String finalPathToAnimals = pathToAnimals;
                ClassLoader loader = new ClassLoader() {

                    @Override
                    public Class<?> findClass(String className) throws ClassNotFoundException {
                        try {
                            byte b[] = fetchClassFromFS(finalPathToAnimals + className + ".class");
                            return defineClass(null, b, 0, b.length);
                        } catch (IOException ex) {
                            return super.findClass(className);
                        }
                    }
                };

                String mName = m.substring(0, m.length() - 6);
                Class clazz = loader.loadClass(mName);
                boolean hasInterface = false;
                Class[] interfaces = clazz.getInterfaces();

                for (Class i : interfaces) {
                    if (Animal.class.equals(i)) {
                        hasInterface = true;
                        break;
                    }
                }

                if (!hasInterface) continue;
                boolean hasConstructor = false;
                Constructor[] constructors = clazz.getConstructors();

                for (Constructor c : constructors) {
                    if (Modifier.isPublic(c.getModifiers()) && c.getParameterTypes().length == 0) {
                        hasConstructor = true;
                        break;
                    }
                }

                if (!hasConstructor) continue;
                result.add((Animal) clazz.newInstance());
            } catch (Exception ignored) {
            }
        }

        return result;
    }

    private static byte[] fetchClassFromFS(String path) throws FileNotFoundException, IOException {
        InputStream is = new FileInputStream(new File(path));

        // Get the size of the file
        long length = new File(path).length();
        if (length > Integer.MAX_VALUE) {
        }

        // Create the byte array to hold the data
        byte[] bytes = new byte[(int) length];

        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }

        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file " + path);
        }

        // Close the input stream and return bytes
        is.close();
        return bytes;
    }
}

/*
ClassLoader - что это такое?
*/
//public class Solution {
//    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
////        System.out.println(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath().substring(1)
////                + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
//        Set<? extends Animal> allAnimals =
//                getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath().substring(1)
//                        + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
//        System.out.println(allAnimals);
//    }
//
//    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        if (!pathToAnimals.endsWith("/") && !pathToAnimals.endsWith("\\")) {
//            pathToAnimals += File.separator;
//        }
//        Set<? extends Animal> allAnimals = new HashSet<>();
////        ArrayList<String> files = findAllJava(pathToAnimals);
////        String[] f = new String[files.size()];
////        int i = 0;
////        for (String s : files) {
////            f[i] = s;
////            i++;
////            System.out.println(s);
////        }
////        for (i = 0; i < files.size(); i++) {
////            MyClassLoader loader = new MyClassLoader(files.get(i));
////            Class clazz= Class.forName(files.get(i),true,loader);
////            Object object= clazz.newInstance();
////            System.out.println(object);
////        }
//        MyClassLoader loader = new MyClassLoader(pathToAnimals, ClassLoader.getSystemClassLoader());
//
//        /**
//         * Получаем список доступных модулей.
//         */
//        File dir = new File(pathToAnimals);
//        String[] modules = dir.list();
//
//        /**
//         * Загружаем и исполняем каждый модуль.
//         */
//        for (String module: modules) {
//            try {
//                String moduleName = module.split(".class")[0];
//                Class clazz = loader.loadClass(moduleName);
//                Module execute = (Module) clazz.newInstance();
//
//                execute.load();
//                execute.run();
//                execute.unload();
//
//            } catch (ClassNotFoundException | InstantiationException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        }
//
////        Class result = defineClass(name, classBytes, 0, classBytes.length);
//
//        return null;
//    }
//
//    private static ArrayList<String> findAllJava(String pathToAnimals) {
//        ArrayList<String> results = new ArrayList<>();
//        File file = new File(pathToAnimals);
////        System.out.println(file);
//        File[] files = new File(pathToAnimals).listFiles();
////If this pathname does not denote a directory, then listFiles() returns null.
//        if (files != null)
//            for (File f : files) {
//                if (f.isFile()) {
//                    results.add(f.getAbsolutePath());
////                    System.out.println(f.getAbsolutePath());
//                }
//            }
//        return results;
//    }
//}