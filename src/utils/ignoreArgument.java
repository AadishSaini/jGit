package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class ignoreArgument {
    public ignoreArgument(String[] args) {
        String[] sliced = Arrays.copyOfRange(args, 1, args.length);

        ArrayList<String> slicedFinal = new ArrayList<>();

        for (String s: sliced) {
            if (Objects.equals(s, "&&")){
                break;
            }
            slicedFinal.add(s);
        }

        this.ignoreFiles(slicedFinal);
    }

    public void ignoreFiles(ArrayList<String> files) {
        general gen = new general();
        for (String s: files) {
            gen.writeInfile(".jGit/.jGitignore", s);
        }
    }
}
