package chap04;

import java.util.ArrayList;
import java.util.LinkedList;

public class Q4 {
    //Given a binary tree, design an algorithm which creates a linked list of all the nodes at
    //each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
    
    ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        if (root != null) //trivial
            current.add(root);
        while (!current.isEmpty()) {
            lists.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<TreeNode>();
            for (TreeNode parent : parents) {
                if (parent.left != null) current.add(parent.left);
                if (parent.right != null) current.add(parent.right);
            }
        }
        return lists;
    }

}
