package chap04;

public class Q7 {
    //Design an algorithm and write code to find the first common ancestor of two
    //nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE:
    //This is not necessarily a binary search tree.
    
    TreeNode findFirstCommonAncestor(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root == null) // trivial
            return null;
        // case 1: n1, n2 reside in two sides -> just return current node
        if (contains(root.left, n1) != contains(root.left, n2))
        /* XXX: OR alternatively:
         * if ((contains(root.left, n1) && contains(root.right, n2)) ||
         *     (contains(root.right, n1) && contains(root.left, n2)))
         */
            return root;
        // case 2: n1, n2 both at the left -> go to left subtree
        else if (contains(root.left, n1) && contains(root.left, n2))
            return findFirstCommonAncestor(root.left, n1, n2);
        // case 3: n1, n2 both at the right -> go to right subtree
        else if (contains(root.right, n1) && contains(root.right, n2))
            return findFirstCommonAncestor(root.right, n1, n2);
        // case 4: n1, n2 not in this tree!
        else
            return null;
    }
    
    private boolean contains(TreeNode root, TreeNode n) {
        if (root == null) return false;
        if (root == n) return true;
        return contains(root.left, n) || contains(root.right, n);
    }
}
