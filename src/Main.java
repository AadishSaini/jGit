import utils.HandleArguments;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello to jGit, type \"java Main --h\" for help");

        if (args.length == 0) {
            System.out.println("You need to provide a command line argument");
        }

        String command = args[0];
        HandleArguments arguments = new HandleArguments();

        arguments.switchCase(command, args);
    }
}
