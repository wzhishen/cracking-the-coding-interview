package chap17;

public class Q13 {
//    Consider a simple node-like data structure called BiNode, which has pointers to two
//    other nodes. The data structure BiNode could be used to represent both a binary
//    tree (where node1 is the left node and node2 is the right node) or a doubly linked
//    list (where node1 is the previous node and node2 is the next node). Implement a
//    method to convert a binary search tree (implemented with BiNode) into a doubly
//    linked list. The values should be kept in order and the operation should be performed
//    in place (that is, on the original data structure).
    
    static BiNode head;
    static BiNode tail;
    
    static void inorderTraverse(BiNode root) {
        if (root == null) return;
        inorderTraverse(root.node1);
        buildList(root);
        inorderTraverse(root.node2);
    }
    
    static void buildList(BiNode n) {
        if (head == null || tail == null) {
            head = tail = n;
            n.node1 = n.node2 = null;
        }
        else {
            tail.node2 = n;
            n.node1 = tail;
            tail = n;
        }
    }
    
    static class BiNode {
        BiNode node1, node2;
        int value;
        public BiNode(int v, BiNode n1, BiNode n2) {value=v; node1=n1; node2=n2;}
        public BiNode(int v) {this(v,null,null);}
    }
    
    //----------------------------------------
    public static void main(String[]args) {
        BiNode n1 = new BiNode(4);
        BiNode n2 = new BiNode(2);
        BiNode n3 = new BiNode(6);
        n2.node1 = new BiNode(1);
        n2.node2 = new BiNode(3);
        n3.node1 = new BiNode(5);
        n1.node1 = n2;
        n1.node2 = n3;
        inorderTraverse(n1);
        printList(head, false);
        System.out.println();
        printList(tail, true);
    }
    
    private static void printList(BiNode n, boolean reversed) {
        while (n != null) {
            System.out.print(n.value+"->");
            n = reversed ? n.node1 : n.node2;
        }
    }

}
