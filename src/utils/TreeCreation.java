package utils;

public class TreeCreation {
    public
    public TreeCreation() {
        General gen = new General();

        String[] lines = gen.readFileLinesToList(".jGit/.addedFiles");
        String[] files = new String[lines.length];

        int i = 0;
        for (String line : lines) {
            files[i] = line.split(" ")[0];
            i++;
        }

        for(String file : files) {

        }

    }
}
