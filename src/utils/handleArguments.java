package utils;

public class handleArguments {
    public void switchCase(String caseName, String[] args) {
        general gen = new general();

        switch (caseName) {
            case "--h":
                System.out.println("You asked for help!");
                break;
            case "--version":
                System.out.println("Version==1.0.0");
                break;
            case "init":
                gen.createDir(".jGit");
                gen.createInitFiles(".jGit");
                break;
            case "add":
                addFile addFile = new addFile(args);

        }
    }
}
