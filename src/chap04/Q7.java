package chap04;

public class Q7 {
    //Design an algorithm and write code to find the first common ancestor of two
    //nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE:
    //This is not necessarily a binary search tree.
    
    TreeNode findFirstCommonAncestor(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root == null) return null; // n1, n2 not in this tree!
        if (root == n1 || root == n2) return root;
        // case 1: n1, n2 reside in two sides -> just return current node
        boolean n1InLeft = contains(root.left, n1);
        boolean n2InLeft = contains(root.left, n2);
        if (n1InLeft != n2InLeft)
            return root;
        // case 2: n1, n2 both at the left -> go to left subtree
        if (n1InLeft && n2InLeft)
            return findFirstCommonAncestor(root.left, n1, n2);
        // case 3: n1, n2 both at the right -> go to right subtree
        if (!n1InLeft && !n2InLeft)
            return findFirstCommonAncestor(root.right, n1, n2);
        return null;
    }
    
    private boolean contains(TreeNode root, TreeNode n) {
        if (root == null) return false;
        if (n == null) return true;
        if (root == n) return true;
        return contains(root.left, n) || contains(root.right, n);
    }
}
