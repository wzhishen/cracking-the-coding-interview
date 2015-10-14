package chap04;

import static helpers.Printer.*;

import helpers.TreeNode;

/**
 * Implement a function to check if a binary tree is a binary search
 * tree. More precisely, the condition is that ALL left nodes must be
 * less than or equal to the current node, which must be less than ALL
 * the right nodes (for all nodes).
 */
public class Q5 {
    public static boolean isBSTNaive(TreeNode n) {
        if (n == null) return true;
        return smallerThan(n.left, n.value) &&
               largerThan(n.right, n.value) &&
               isBSTNaive(n.left) &&
               isBSTNaive(n.right);
    }

    private static boolean largerThan(TreeNode n, int val) {
        if (n == null) return true;
        return n.value > val && largerThan(n.left, val) && largerThan(n.right, val);
    }

    private static boolean smallerThan(TreeNode n, int val) {
        if (n == null) return true;
        return n.value <= val && smallerThan(n.left, val) && smallerThan(n.right, val);
    }

    public static boolean isBST(TreeNode n) {
        return isBST(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBST(TreeNode n, int min, int max) {
        if (n == null) return true;
        if (n.value <= min || n.value > max) return false;
        return isBST(n.left, min, n.value) && isBST(n.right, n.value, max);
    }

    // wrong implementation
    public static boolean isBSTWrong(TreeNode n) {
        if (n == null) return true;
        if (n.left != null && n.left.value > n.value) return false;
        if (n.right != null && n.right.value <= n.value) return false;
        return isBSTWrong(n.left) && isBSTWrong(n.right);
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        /*
         *     4
         *    / \
         *   2   5
         *  / \
         * 1   3
         */
        TreeNode n1 = new TreeNode(2), n2 = new TreeNode(3), r = new TreeNode(4);
        n1.left = new TreeNode(1); n1.right = n2;
        r.left = n1; r.right = new TreeNode(5);
        TreeNode.printTree(r);
        println("isBSTNaive: " + isBSTNaive(r));
        println("isBST:      " + isBST(r));
        println("isBSTWrong: " + isBSTWrong(r));
        println();
        /*
         *   2
         *  / \
         * 1   4
         *  \
         *   3
         */
        n1 = new TreeNode(1); n1.right = new TreeNode(3);
        r = new TreeNode(2); r.left = n1; r.right = new TreeNode(4);
        TreeNode.printTree(r);
        println("isBSTNaive: " + isBSTNaive(r));
        println("isBST:      " + isBST(r));
        println("isBSTWrong: " + isBSTWrong(r));
    }
}
