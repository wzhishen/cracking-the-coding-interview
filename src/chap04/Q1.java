package chap04;

public class Q1 {
    //Implement a function to check if a binary tree is balanced. For the purposes of this
    //question, a balanced tree is defined to be a tree such that the heights of the two
    //subtrees of any node never differ by more than one.
    
    boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }
    
    private int getHeight(TreeNode n) {
        if (n == null) return 0;
        return Math.max(getHeight(n.left), getHeight(n.right)) + 1;
    }
    
    boolean isBalanced2(TreeNode root) {
        return getHeight2(root) == -1;
    }
    
    private int getHeight2(TreeNode n) {
        if (n == null) return 0;
        if (getHeight2(n.left) == -1 || getHeight2(n.right) == -1)
            return -1;
        if (Math.abs(getHeight2(n.left) - getHeight2(n.right)) > 1)
            return -1;
        else
            return Math.max(getHeight2(n.left), getHeight2(n.right)) + 1;
    }
}
