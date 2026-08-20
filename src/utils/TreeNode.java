package utils;

import java.util.HashMap;
import java.util.Map;

public class TreeNode {
    String name;
    String hash;
    String isFile;

    Map<String, TreeNode> children;

    public TreeNode(String name, String hash, String isFile) {
        this.name = name;
        this.hash = hash;
        this.isFile = isFile;
        this.children = new HashMap<>();
    }
}
