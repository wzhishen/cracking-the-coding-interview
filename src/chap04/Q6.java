package chap04;

public class Q6 {
    //Write an algorithm to find the'next'node (i.e., in-order successor) of a given node
    //in a binary search tree. You may assume that each node has a link to its parent.
    
    TreeNode inorderSuccessor(TreeNode n) {
        if (n == null) return null;//trivial
        
        // case 1: n has right subtree -> just return leftmost node of right subtree
        if (n.right != null) return leftmostChild(n.right);
        
        // n has no right subtree
        // case 2.1: n is left child of its parent -> just return its parent
        while (n.parent != null && n.parent.right == n) {
            n = n.parent; // case 2.2: n is right child of its parent -> n goes up until n is left child of its parent, then return its parent
                          // case 3: n is the last node in traversal -> return root's parent, ie., null
        }
        return n.parent;
    }
    
    private TreeNode leftmostChild(TreeNode n) {
        if (n.left == null) return n;
        return leftmostChild(n.left);
    }
}
