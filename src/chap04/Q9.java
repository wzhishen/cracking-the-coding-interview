package chap04;

public class Q9 {
    static //You are given a binary tree in which each node contains a value. Design an algorithm
    //to print all paths which sum to a given value. The path does not need to
    //start or end at the root or a leaf.
    
    void findSum(TreeNode root, int sum) {
        findSum(root, sum, new int[getHeight(root)], 0);
    }
    
    private static void findSum(TreeNode n, int sum, int[] path, int level) {
        if (n == null) return;
        
        path[level] = n.value;
        int s = 0;
        for (int i = level; i >= 0; --i) {
            s += path[level];
            if (s == sum)
                print(path, i, level);
        }
        
        findSum(n.left, sum, path, level + 1);
        findSum(n.right, sum, path, level + 1);
    }
    
    private static int getHeight(TreeNode n) {
        if (n == null) return 0;
        return Math.max(getHeight(n.left), getHeight(n.right)) + 1;
    }
    
    private static void print(int[] path, int start, int end) {
        for (int i = start; i <= end; ++i) {
            System.out.print(path[i] + " ");
        }
        System.out.println();
    }
    
    //------------------------------
    public static void main(String[]args) {
        TreeNode r = new TreeNode(1);
        TreeNode n1 = new TreeNode(3); n1.right=new TreeNode(0);
        TreeNode n2 = new TreeNode(2);TreeNode n3=new TreeNode(1);n3.left=new TreeNode(-1);
        n2.left=n3;r.left=n2;r.right=n1;
        findSum(r, 3);
    }
}
