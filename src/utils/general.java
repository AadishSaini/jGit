package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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

    public void createFile(String path){
        Path pathToCreateTo = Paths.get(path);

        try {
            // Create the empty file
            Files.createFile(pathToCreateTo);
            System.out.println("File created successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred or file already exists: " + e.getMessage());
        }
    }
    public void createInitFiles(String path) {
        createFile(".jGit/.jGitignore");
        createFile(".jGit/.addedFiles");
        createFile(".jGit/.branchInfo");
    }

    public void writeInfile(String path, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.write(content);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
