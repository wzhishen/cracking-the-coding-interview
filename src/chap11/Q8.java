package chap11;

public class Q8 {
    /*Imagine you are reading in a stream of integers. Periodically, you wish to be able
    to look up the rank of a number x (the number of values less than or equal tox).
    Implement the data structures and algorithms to support these operations.That
    is, implement the method track(int x), which is called when each number
    is generated, and the method getRankOfNumber(int x), which returns the
    number of values less than or equal to x (not including x itself).
    EXAMPLE
    Stream (in order of appearance): 5, 1, 4, 4, 5, 9, 7, 13, 3
    getRankOfNumber(l) = 0
    getRankOfNumber(3) = 1
    getRankOfNumber(4) = 3
    */
    
    private static NodeWithRank root = null;
    
    static void insert(int v, NodeWithRank root) {
        NodeWithRank newNode = new NodeWithRank(v);
        if (root == null) root = newNode;
        else if (v > root.value) {
            if (root.right == null)
                root.right = newNode;
            else
                insert(v, root.right);
        }
        else {
            ++root.leftSize;
            if (root.left == null)
                root.left = newNode;
            else
                insert(v, root.left);
        }
    }
    
    static int getRank(int v, NodeWithRank root) {
        if (root == null) return -1;
        if (v == root.value) {
            return root.leftSize;
        }
        else if (v > root.value) {
            int rightRank = getRank(v, root.right);
            return rightRank == -1 ? -1 : root.leftSize + 1 + rightRank;
        }
        else {
            int leftRank = getRank(v, root.left);
            return leftRank == -1 ? -1 : leftRank;
        }
    }
    
    static int getRankOfNumber(int x) {
        if (root == null) return -1;
        return getRank(x, root);
    }
    
    static void track(int x) {
        if (root == null) root = new NodeWithRank(x);
        else insert(x, root);
    }
    
    //----------------------------------------
    public static void main(String[]args) {
        track(5);track(1);track(4);track(4);track(5);track(9);track(7);track(13);track(3);
        System.out.println(getRankOfNumber(1));
        System.out.println(getRankOfNumber(3));
        System.out.println(getRankOfNumber(4));
        System.out.println(getRankOfNumber(13));
    }
    
    static class NodeWithRank {
        int value;
        int leftSize = 0;
        NodeWithRank left = null;
        NodeWithRank right = null;
        public NodeWithRank(int v) {
            value = v;
        }
    }
}
