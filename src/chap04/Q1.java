package chap04;

public class Q1 {
    //Implement a function to check if a binary tree is balanced. For the purposes of this
    //question, a balanced tree is defined to be a tree such that the heights of the two
    //subtrees of any node never differ by more than one.
    
    boolean isBalanced2(TreeNode root) {
        return getHeight2(root) != -1;
    }
    
    // Check if the tree is balanced as the same time as it's checking heights.
    // 0(N) time and 0(H) space, where H is the height of the tree.
    private int getHeight2(TreeNode n) {
        if (n == null) return 0;
        int leftHeight = getHeight2(n.left);
        int rightHeight = getHeight2(n.right);
        if (leftHeight == -1 || rightHeight == -1) // catch info for unbalanced subtree, and recurse to top
            return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) // if this subtree is not balanced, we break immediately
            return -1;
        else
            return Math.max(leftHeight, rightHeight) + 1;
    }
    
    //O(n^2)
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
    
}
