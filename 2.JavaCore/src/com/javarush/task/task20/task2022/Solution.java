package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
//        out.writeObject(this.fileName);
        out.defaultWriteObject();
//        out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
//        this.fileName = (String) in.readObject();
        this.stream = new FileOutputStream(this.fileName,true);
//        in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        String fileName = "c:\\111\\1.a";
        Solution s = new Solution(fileName);
//        System.out.println(s);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
        s.writeObject(fileName);
        out.writeObject(s);
//        System.out.println(s);
        s.close();
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
        Solution s1= (Solution) in.readObject();
        s1.readObject(in);
        System.out.println(s1);
        s1.close();

    }
}
