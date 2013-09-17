package chap04;

public class Q5 {
    //Implement a function to check if a binary tree is a binary search tree.
    //
    //More precisely, the condition is that ALL left nodes must be less than or equal to the
    //current node, which must be less than ALL the right nodes. (for all nodes)
    
    boolean isBST(TreeNode root) {
        if (root == null) return true; //necessary
        return smallerThan(root.left, root.value) && largerThan(root.right, root.value)
                && isBST(root.left)
                && isBST(root.right);
    }
    
    private boolean smallerThan(TreeNode n, int v) {
        if (n == null) return true;
        return n.value <= v && smallerThan(n.left, v) && smallerThan(n.right, v); 
    }
    
    private boolean largerThan(TreeNode n, int v) {
        if (n == null) return true;
        return n.value > v && largerThan(n.left, v) && largerThan(n.right, v); 
    }
}
