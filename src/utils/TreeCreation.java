package utils;


import java.util.Arrays;
import java.util.HashMap;

public class TreeCreation {
    public String[] getFiles() {
        General gen = new General();

        String[] lines = gen.readFileLinesToList(".jGit/.addedFiles");
        String[] files = new String[lines.length];

        int i = 0;
        for (String line : lines) {
            files[i] = line;
            i++;
        }

        return files;
    }


    public void printTree(TreeNode node) {
        printTree(node, "", true);
    }

    private void printTree(TreeNode node, String prefix, boolean isLast) {
        String type = node.isFile ? "FILE" : "DIR";

        System.out.println(
                prefix +
                        (isLast ? "└── " : "├── ") +
                        node.name +
                        " [" + type + "]" +
                        " hash=" + node.hash
        );

        int size = node.children.size();
        int i = 0;

        for (TreeNode child : node.children.values()) {
            i++;

            String childPrefix =
                    prefix + (isLast ? "    " : "│   ");

            printTree(child, childPrefix, i == size);
        }
    }


    public TreeCreation() {
        String[] files = getFiles();
        System.out.print("[");
        for (String file : files) {
            System.out.print(file+", ");
        }
        System.out.print("]");




        TreeNode root = new TreeNode("ROOT", "", false);
        TreeNode curr = root;

        for (String file : files) {
            String[] folderOrFiles = file.split("/");
            for (int i = 1; i <= folderOrFiles.length; i++) {
                String folderOrFile = folderOrFiles[i-1];
                // the file/folder already exists
                if (curr.children.containsKey(folderOrFile)) {
                    curr = curr.children.get(folderOrFile);
                }
                // the file/folder does not exist
                else {
                    // the given "folderOrFiles" is the file (isFile = True)
                    if (i == folderOrFiles.length) {
                        String[] nameAndHash = folderOrFile.split(" ");
                        TreeNode newFileNode = new TreeNode(nameAndHash[0], nameAndHash[1], true);
                        curr.children.put(folderOrFile, newFileNode);
                        break;
                    }
                    // the given "folderOrFile" is a folder (isFile = False)
                    else {
                        TreeNode newDirectoryNode = new TreeNode(folderOrFile, "", false);
                        curr.children.put(folderOrFile, newDirectoryNode);
                        curr = curr.children.get(folderOrFile);
                    }
                }
            }
            curr = root;
        }

        System.out.println();
        printTree(root);

    }
}
