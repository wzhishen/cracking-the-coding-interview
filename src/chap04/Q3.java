package chap04;

import static helpers.Printer.*;

import helpers.TreeNode;

/**
 * Given a sorted (increasing order) array with unique integer
 * elements, write an algorithm to create a binary search tree
 * with minimal height.
 */
public class Q3 {
    public static TreeNode createBST(int[] a) {
        if (a == null) return null;
        return createBST(a, 0, a.length - 1);
    }

    private static TreeNode createBST(int[] a, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode n = new TreeNode(a[mid]);
        n.left = createBST(a, start, mid - 1);
        n.right = createBST(a, mid + 1, end);
        return n;
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        TreeNode.printTree(createBST(new int[] {}));
        println();
        TreeNode.printTree(createBST(new int[] {0}));
        println();
        TreeNode.printTree(createBST(new int[] {0,1}));
        println();
        TreeNode.printTree(createBST(new int[] {0,1,2,3,4}));
        println();
        TreeNode.printTree(createBST(new int[] {-1,0,1,3,4,7,9}));
        println();
    }
}
