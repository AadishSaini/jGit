package utils;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class addFile {
    public addFile(String[] completeInstructionSet){
        String[] sliced = Arrays.copyOfRange(completeInstructionSet, 1, completeInstructionSet.length);

        ArrayList<String> slicedFinal = new ArrayList<>();

        for (String s : sliced) {
            if (Objects.equals(s, "&&")) {
                break;
            }
            slicedFinal.add(s);
        }
        this.addFiles(slicedFinal);
    }

    public void addFiles(ArrayList<String> sliced){
        general gen=new general();
        for (String s : sliced) {
            gen.writeInfile(".jGit/.addedFiles", s);
        }
    }
}
