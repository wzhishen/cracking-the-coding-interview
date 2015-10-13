package chap04;

import static helpers.Printer.*;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Given a binary tree, design an algorithm which creates a linked
 * list of all the nodes at each depth (e.g., if you have a tree
 * with depth D, you'll have D linked lists).
 */
public class Q4 {
    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        if (root != null) current.add(root);
        while (!current.isEmpty()) {
            result.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<TreeNode>();
            for (TreeNode parent : parents) {
                if (parent.left != null) current.add(parent.left);
                if (parent.right != null) current.add(parent.right);
            }
        }
        return result;
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        /*
         *     4
         *    / \
         *   1   5
         *  / \   \
         * 2   3   7
         *      \
         *       6
         */
        TreeNode n1 = new TreeNode(1), n2 = new TreeNode(3), 
                 n3 = new TreeNode(5), r = new TreeNode(4);
        n1.left = new TreeNode(2); n1.right = n2; n2.right = new TreeNode(6);
        r.left = n1; r.right = n3; n3.right = new TreeNode(7);
        TreeNode.printTree(r);
        println();

        ArrayList<LinkedList<TreeNode>> levels = createLevelLinkedList(r);
        for (LinkedList<TreeNode> level : levels) {
            for (TreeNode node : level) {
                print(node + " ");
            }
            println();
        }
    }
}
