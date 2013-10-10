package chap04;

public class Q3 {
    //Given a sorted (increasing order) array with unique integer elements, write an algorithm
    //to create a binary search tree with minimal height.
    
    private TreeNode createMinBST(int[] a, int start, int end) {
        if (a == null) return null;
        if (end < start) return null;
        int mid = start + (end - start) / 2;
        TreeNode n = new TreeNode(a[mid]);
        n.left = createMinBST(a, start, mid - 1);
        n.right = createMinBST(a, mid + 1, end);
        return n;
    }
    
    TreeNode createMinBST(int[] a) {
        return createMinBST(a, 0, a.length - 1);
    }
}
