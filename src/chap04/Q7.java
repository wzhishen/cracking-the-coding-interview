package chap04;

import static helpers.Printer.*;

import helpers.TreeNode;

/**
 * Design an algorithm and write code to find the first common
 * ancestor of two nodes in a binary tree. Avoid storing additional
 * nodes in a data structure. NOTE: This is not necessarily a binary
 * search tree.
 */
public class Q7 {
    public static TreeNode findFirstCommonAncestor(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root == null) return null;
        if (root == n1 && contains(root, n2) ||
            root == n2 && contains(root, n1)) return root;
        boolean n1OnLeft = contains(root.left, n1);
        boolean n2OnLeft = contains(root.left, n2);
        if (n1OnLeft && n2OnLeft) {
            return findFirstCommonAncestor(root.left, n1, n2);
        } else if (!n1OnLeft && !n2OnLeft) {
            return findFirstCommonAncestor(root.right, n1, n2);
        } else {
            return root;
        }
    }

    private static boolean contains(TreeNode root, TreeNode n) {
        if (root == null) return false;
        if (root == n) return true;
        return contains(root.left, n) || contains(root.right, n);
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        /*
         *     4
         *    / \
         *   2   5
         *  / \   \
         * 1   3   7
         *    /
         *   6
         */
        TreeNode n1 = new TreeNode(1), n2 = new TreeNode(2), n3 = new TreeNode(3),
                 n4 = new TreeNode(4), n5 = new TreeNode(5), n6 = new TreeNode(6),
                 n7 = new TreeNode(7);
        n2.left = n1; n2.right = n3; n4.left = n2; n4.right = n5; n3.left = n6;
        n5.right = n7;
        TreeNode.printTree(n4);
        println();
        printfln("FirstCommonAncestor of %s, %s: %s", n1, n6, findFirstCommonAncestor(n4, n1, n6));
        printfln("FirstCommonAncestor of %s, %s: %s", n1, n7, findFirstCommonAncestor(n4, n1, n7));
        printfln("FirstCommonAncestor of %s, %s: %s", n4, n5, findFirstCommonAncestor(n4, n4, n5));
        printfln("FirstCommonAncestor of %s, %s: %s", n5, n5, findFirstCommonAncestor(n4, n5, n5));
    }
}
