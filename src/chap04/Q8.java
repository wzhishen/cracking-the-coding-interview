package chap04;

public class Q8 {
    /*You have two very large binary trees: Tl, with millions of nodes, and T2, with
    hundreds of nodes. Create an algorithm to decide if T2 is a subtree ofTl.
    A tree T2 is a subtree of Tl if there exists a node n in Tl such that the subtree ofn
    is identical to T2. That is, if you cut off the tree at node n, the two trees would be
    identical.*/
    
    boolean isSubtree(TreeNode n1, TreeNode n2) {
        // a null tree is always a subtree
        if (n2 == null) return true;
        // shape not identical
        if (n1 == null) return false;
        if (isIdentical(n1, n2)) return true;
        return isSubtree(n1.left, n2) || isSubtree(n1.right, n2);
    }
    
    private boolean isIdentical(TreeNode n1, TreeNode n2) {
        // shape identical
        if (n1 == null && n2 == null) return true;
        // shape not identical
        if (n1 == null || n2 == null) return false;
        // value not identical
        if (n1.value != n2.value) return false;
        // recurse to check all nodes
        return isIdentical(n1.left, n2.left) &&
                isIdentical(n1.right, n2.right);
    }
    
    /* Alternative:
     * Compare whether T2's pre-order/in-order traversal string is a substring of
     * T1's pre-order/in-order traversal string.
     * Fast but waste memory, not good for large tree
     */
}
