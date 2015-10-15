package chap04;

import static helpers.Printer.*;

import helpers.TreeNode;

/**
 * Write an algorithm to find the 'next' node (i.e., in-order successor)
 * of a given node in a binary search tree. You may assume that each node
 * has a link to its parent.
 */
public class Q6 {
    public static TreeNode inorderSuccessor(TreeNode n) {
        if (n == null) return null;

        // case 1: n has right subtree ->
        //         return leftmost node of right subtree
        if (n.right != null) return leftmostChild(n.right);

        // case 2:   n has no right subtree
        // case 2.1: n is left child of its parent ->
        //           just return its parent
        // case 2.2: n is right child of its parent ->
        //           n goes up until n is left child of its parent,
        //           then return this parent
        // case 3:   n is the last node in traversal ->
        //           return root's parent, ie., null
        while (n.parent != null && n.parent.right == n) {
            n = n.parent; 
        }
        return n.parent;
    }

    private static TreeNode leftmostChild(TreeNode n) {
        if (n.left == null) return n;
        return leftmostChild(n.left);
    }

    public static TreeNode preorderSuccessor(TreeNode n) {
        if (n == null) return null;

        // case 1: n has a child ->
        //         just return that child (left if exists, otherwise right)
        if (n.left != null) return n.left;
        else if (n.right != null) return n.right;
        // case 2: n has no child ->
        //         n climbs up until reaching a parent that has a right child
        //         (which is not n), then return this right child
        while (n.parent != null && (n.parent.right == null || n.parent.right == n)) {
            n = n.parent;
        }
        // case 3: n is the last node in traversal ->
        //         return root's parent, ie., null
        if (n.parent == null) return null;
        return n.parent.right;
    }

    public static TreeNode postorderSuccessor(TreeNode n) {
        // case 1: n is the last node in traversal ->
        //         return root's parent, ie., null
        if (n == null || n.parent == null) return null;
        // case 2:   n is left child of its parent ->
        //           just return parent
        // case 3:   n is right child of its parent
        // case 3.1: parent has no right child ->
        //           just return parent
        if (n.parent.right == n || n.parent.right == null) return n.parent;
        // case 3.2: parent has right child ->
        //           return leftmost bottom node of parent's right subtree
        return leftmostBottomChild(n.parent.right);
    }

    private static TreeNode leftmostBottomChild(TreeNode n) {
        if (n.left == null && n.right == null) return n;
        if (n.left != null) {
            return leftmostBottomChild(n.left);
        } else {
            return leftmostBottomChild(n.right);
        }
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
        TreeNode n1 = new TreeNode(1), n2 = new TreeNode(2), n3 = new TreeNode(3),
                 n4 = new TreeNode(4), n5 = new TreeNode(5);
        n2.left = n1; n2.right = n3; n1.parent = n2; n3.parent = n2;
        n4.left = n2; n4.right = n5; n2.parent = n4; n5.parent = n4;
        TreeNode.printTree(n4);

        TreeNode n = n4;
        print("pre-order:  ");
        while (n != null) {
            print(n + " ");
            n = preorderSuccessor(n);
        }
        print("\nin-order:   ");
        n = n1;
        while (n != null) {
            print(n + " ");
            n = inorderSuccessor(n);
        }
        print("\npost-order: ");
        n = n1;
        while (n != null) {
            print(n + " ");
            n = postorderSuccessor(n);
        }
    }
}
