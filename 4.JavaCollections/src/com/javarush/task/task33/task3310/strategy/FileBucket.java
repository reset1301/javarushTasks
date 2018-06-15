package com.javarush.task.task33.task3310.strategy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {
    private Path path;

    public FileBucket() throws IOException {
        this.path = Files.createTempFile("" + System.currentTimeMillis(), ".tmp");
        Files.deleteIfExists(path);
        Files.createFile(path);
        path.toFile().deleteOnExit();
    }

    public long getFileSize() {
        try {
            return Files.size(path);
        } catch (IOException e) {
            return 0;
        }
    }

    public void putEntry(Entry entry) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path));
        oos.writeObject(entry);
        oos.flush();
        oos.close();
    }

    public Entry getEntry() throws IOException, ClassNotFoundException {
        if (getFileSize() == 0)
            return null;
        ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path));
        return (Entry) ois.readObject();
    }

    public void remove() throws IOException {
        Files.delete(path);
    }
}
