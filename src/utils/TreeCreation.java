package utils;

import com.sun.source.tree.Tree;

public class TreeCreation {
    public TreeNode recursiveCallToTreeChildren(TreeNode curr, String[] nameHash){
        if (curr.children == null) {
            TreeNode dir = new TreeNode(nameHash[0], " ", false);
            curr.children.put(nameHash[0], dir);
            return dir;
        }
        for (TreeNode child : curr.children.values()) {
            recursiveCallToTreeChildren(child, nameHash);
        }
        return new TreeNode("", "", false);
    }

    public void printTree(TreeNode root){
        System.out.println(root.name);
        for (TreeNode child : root.children.values()) {
            printTree(child);
        }
    }

    public TreeCreation() {
        General gen = new General();

        String[] lines = gen.readFileLinesToList(".jGit/.addedFiles");
        String[] files = new String[lines.length];

        int i = 0;
        for (String line : lines) {
            files[i] = line.split(" ")[0];
            i++;
        }

        i = files.length;
        for(String file: files){
            System.out.println(file);
        }
        TreeNode root = new TreeNode(".", "", false);

        for (String line : lines) {
            String[] test = line.split("/");
            for(String currIter: test){
                String[] nameHash = currIter.split(" ");
                if (nameHash.length > 1) {
                    TreeNode fileNode = new TreeNode(nameHash[0], nameHash[1], true);
                    // appending the node in the tree


                }

                // dirs
                recursiveCallToTreeChildren(root, nameHash);
                printTree(root);


            }
        }
    }
}
