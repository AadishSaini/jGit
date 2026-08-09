package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class general {

    public void createDir(String path) {
        Path testFolderPath = Paths.get(path);

        if (Files.isDirectory(testFolderPath)) {
            System.out.println("The folder exists.");
        } else {
            System.out.println("The folder does not exist, hence, creating the folder "+path);
            Path singleFolder = Paths.get(path);
            try{
                Files.createDirectories(singleFolder);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void createInitFiles(String path) {}
}
