package helpers;

import static helpers.Printer.*;

public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent; /* only used for certain cases */

    public TreeNode(int x) {
        value = x;
    }

    public String toString() {
        return String.valueOf(value);
    }

    public static void printTree(TreeNode n) {
        if (n == null) return;
        println(n.value);
        printTree(n.left, 0, true);
        printTree(n.right, 0, false);
    }

    private static void printTree(TreeNode n, int level, boolean isLeft) {
        if (n == null) return;
        for (int i = 0; i < level; ++i) print("  ");
        if (isLeft)
            println("/- " + n.value);
        else
            println("\\- " + n.value);
        printTree(n.left, level + 1, true);
        printTree(n.right, level + 1, false);
    }
}
