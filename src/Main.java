import utils.handleArguments;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello to jGit, type \"java Main --h\" for help");

        if (args.length == 0) {
            System.out.println("You need to provide a command line argument");
        }

        String command = args[0];
        handleArguments arguments = new handleArguments();

        arguments.switchCase(command, args);
    }
}
