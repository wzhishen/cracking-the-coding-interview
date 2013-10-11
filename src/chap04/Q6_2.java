package chap04;

public class Q6_2 {
    TreeNode preorderSuccessor(TreeNode n) {
        if (n == null) return null;
        
        // case 1: n has child (either left or right) -> just return that child
        if (n.left != null) return n.left;
        else if (n.right != null) return n.right;
        
        // case 2: n has no child. Climb up until reaching a parent has a right child (which is not n) -> return this right child
        while (n.parent != null && (n.parent.right == null || n.parent.right == n)) {
            n = n.parent;
        }
        if (n.parent == null) return null; // case 3: n is the last node in traversal
        return n.parent.right;
    }
    
    TreeNode postorderSuccessor(TreeNode n) {
        // case 1: n has no parent -> return null
        if (n == null || n.parent == null) return null;
        
        // case 2.1: n's parent has no right child -> just return parent
        // case 2.2: n is a right child of its parent -> just return parent
        if (n.parent.right == null || n.parent.right == n) return n.parent;
        
        // case 3: n's parent has right child (which is not n) -> find left-bottom-most child of parent's right subtree
        return leftBottomChild(n.parent.right);
    }
    
    private TreeNode leftBottomChild(TreeNode n) {
        // find leftmost child
        while (n.left != null) {
            n = n.left;
        }
        //find bottom-most child
        if (n.right != null) n = n.right;
        return n;
    }

}
