package chap04;

import static helpers.Printer.*;

import helpers.TreeNode;

/**
 * You have two very large binary trees: Tl, with millions of
 * nodes, and T2, with hundreds of nodes. Create an algorithm
 * to decide if T2 is a subtree of Tl. A tree T2 is a subtree
 * of Tl if there exists a node n in Tl such that the subtree
 * of n is identical to T2. That is, if you cut off the tree
 * at node n, the two trees would be identical.
 */
public class Q8 {
    public static boolean isSubtree(TreeNode t1, TreeNode t2) {
        if (t2 == null) return true;
        if (t1 == null) return false;
        if (isIdentical(t1, t2)) return true;
        return isSubtree(t1.left, t2) ||
               isSubtree(t1.right, t2);
    }

    private static boolean isIdentical(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        if (n1.value != n2.value) return false;
        return isIdentical(n1.left, n2.left) &&
               isIdentical(n1.right, n2.right);
    }

    /* Alternative:
     * Compare whether T2's leaf-delimited traversal string (pre-order,
     * in-order, etc) is a substring of T1's. Fast but waste memory, not
     * good for large trees.
     */
    public static boolean isSubtree2(TreeNode t1, TreeNode t2) {
        return getTraversalStr(t1).contains(getTraversalStr(t2));
    }

    private static String getTraversalStr(TreeNode n) {
        StringBuilder sb = new StringBuilder();
        preorderTraverse(n, sb);
        return sb.toString();
    }

    private static void preorderTraverse(TreeNode n, StringBuilder sb) {
        if (n == null) {
            sb.append("\0");
        } else {
            sb.append(n.value);
            preorderTraverse(n.left, sb);
            preorderTraverse(n.right, sb);
        }
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
        println(isSubtree(n4, n2));
        println(isSubtree2(n4, n2));
        println();
        println(isSubtree(n2, n5));
        println(isSubtree2(n2, n5));
    }
}
