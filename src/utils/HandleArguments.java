package utils;

public class HandleArguments {
    public void switchCase(String caseName, String[] args) {
        General gen = new General();
        for (String arg : args) {
            System.out.println(arg);
        }
        switch (caseName) {
            case "--h":
                System.out.println("You asked for help!");
                break;
            case "--version":
                System.out.println("Version==1.0.0");
                break;
            case "init":
                gen.createDir(".jGit");
                gen.createInitFilesAndFolders(".jGit");
                break;
            case "add":
                AddFile addFile = new AddFile(args);
                break;
            case "ignore":
                IgnoreArgument ignoreArgument = new IgnoreArgument(args);
                break;
            case "tree":
                TreeCreation tree = new TreeCreation();
                break;
        }
    }
}
