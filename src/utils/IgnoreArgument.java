package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class IgnoreArgument {
    public IgnoreArgument(String[] args) {
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
        General gen = new General();
        for (String s: files) {
            gen.writeInfile(".jGit/.jGitignore", s);
        }
    }
}
