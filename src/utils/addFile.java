package utils;


import java.util.ArrayList;
import java.util.Arrays;

public class addFile {
    public addFile(String[] completeInstructionSet){
        String[] sliced = Arrays.copyOfRange(completeInstructionSet, 1, completeInstructionSet.length);

        ArrayList<String> slice = new ArrayList<>(Arrays.asList(sliced));

        int i = 0;
        while(sliced[i] != "&&") {
            slice.add(sliced[i]);
            i++;
        }

        this.createFiles(sliced);
    }

    public void createFiles(String[] sliced){
        for(int i = 0; i < sliced.length; i++) {

        }
    }
}
