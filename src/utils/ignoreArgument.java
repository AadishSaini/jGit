package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;

public class ignoreArgument {
    public ignoreArgument(String[] args) {
        String[] sliced = Arrays.copyOfRange(args, 1, args.length);

        ArrayList<String> slice = new ArrayList<>(Arrays.asList(sliced));

        int i = 0;
        while(sliced[i] != "&&") {
            slice.add(sliced[i]);
            i++;
        }

        this.ignoreFiles(sliced);
    }

    public void ignoreFiles(String[] files) {
        Path path = Paths.get("/.jGit/.branchInfo");
        String textToAppend = String.join("\n", files);

        try {
            Files.write(path, textToAppend.getBytes(), StandardOpenOption.APPEND);
            System.out.println("Successfully wrote to the file!");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
