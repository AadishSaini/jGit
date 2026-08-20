package utils;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class AddFile {
    public AddFile(String[] completeInstructionSet){
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
        General gen=new General();
        String fileContent;
        for (String s : sliced) {
            gen.writeInfile(".jGit/.addedFiles", s);

            fileContent = gen.readInfile(s);
            System.out.println("AddFile called and read the content of file "+ s+ "!: \""+fileContent+"\"");

            String hashValue = createSha1(fileContent);
            System.out.println("Created the hash for the file "+ s+ "!: \""+hashValue+"\"");

            gen.createDir(".jGit/objects/"+hashValue.substring(0, 2));
            String blobDirectory = ".jGit/objects/" +
                    hashValue.substring(0, 2) +
                    "/" + hashValue.substring(2);
            gen.createFile(
                    blobDirectory
            );
            gen.writeInfile(
                    blobDirectory,
                    "blob " + Integer.toString(fileContent.length())+"\0"+fileContent
            );
        }
    }

    public String createSha1(String fileContent) {
        return ToSHA1.SHA1(
                "blob " + Integer.toString(fileContent.length())+"\0"+fileContent
        );
    }
}
