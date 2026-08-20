package utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class General {

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
    public void createInitFilesAndFolders(String path) {
        createDir(".jGit/objects");
        createFile(".jGit/.jGitignore");
        createFile(".jGit/.addedFiles");
        createFile(".jGit/.branchInfo");
    }

    public void writeInfileAppend(String path, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.write(content);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    public String readInfile(String path) {
        String content = "";
        try (BufferedReader reader = Files.newBufferedReader(Path.of(path), StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                content += line;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content;
    }

    public static String[] readFileLinesToList(String path) {
        String[] linesFinal = new String[0];
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            linesFinal = lines.toArray(String[]::new);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return linesFinal;
    }

}
