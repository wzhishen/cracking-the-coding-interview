package chap04;

public class Q5_2 {
    //Implement a function to check if a binary tree is a binary search tree.
    //
    //More precisely, the condition is that ALL left nodes must be less than or equal to the
    //current node, which must be less than ALL the right nodes. (for all nodes)
    
    /* possibly BETTER: check by narrowing range for each node */
    private boolean isBST(TreeNode n, int min, int max) {
        if (n == null) return true;
        if (n.value < min || n.value >= max) return false;
        if (!isBST(n.left, min, n.value)) return false;
        if (!isBST(n.right, n.value, max)) return false;
        return true;
    }
    
    boolean isBST(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
