package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;

public class FileFactory implements ResourceFactory<FileWriter> {
    AtomicInteger id = new AtomicInteger(0);
    private final String path;

    public FileFactory(String path) {
        this.path = path;
    }

    public FileWriter create() {
        File direct = new File(path);
        if (!direct.exists()) {
            Path pathToCreate = Paths.get(path);
            try {
                Files.createDirectory(pathToCreate);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        Integer newFileId = id.incrementAndGet();
        String newFileName = path + "\\" + newFileId.toString() + ".txt";
        try {
            return new FileWriter(newFileName);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
