package chap17;

import static helpers.Printer.*;

/**
 * Consider a simple node-like data structure called BiNode,
 * which has pointers to two other nodes. The data structure
 * BiNode could be used to represent both a binary tree (where
 * node1 is the left node and node2 is the right node) or a
 * doubly linked list (where node1 is the previous node and
 * node2 is the next node). Implement a method to convert a
 * binary search tree (implemented with BiNode) into a doubly
 * linked list. The values should be kept in order and the
 * operation should be performed in place (that is, on the
 * original data structure).
 */
public class Q13 {
    public static void inorderTraverse(BiNode n) {
        if (n == null) return;
        inorderTraverse(n.node1);
        addNode(n);
        inorderTraverse(n.node2);
    }

    private static void addNode(BiNode n) {
        if (head == null) {
            head = tail = n;
            head.node1 = head.node2 = null;
        } else {
            tail.node2 = n;
            n.node1 = tail;
            tail = n;
        }
    }

    private static BiNode head = null, tail = null;

    private static class BiNode {
        BiNode node1, node2;
        int value;
        public BiNode(int v, BiNode n1, BiNode n2) {
            value = v;
            node1 = n1;
            node2 = n2;
        }
        public BiNode(int v) {
            this(v, null, null);
        }
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        final int N = 7;
        BiNode[] ns = new BiNode[N + 1];
        for (int i = 1; i < ns.length; ++i) {
            ns[i] = new BiNode(i);
        }
        /*
         *     7
         *    / \
         *   3   2
         *  /   / \
         * 1   4   5
         *      \
         *       6
         */
        BiNode root = ns[7];
        ns[7].node1 = ns[3];
        ns[3].node1 = ns[1];
        ns[7].node2 = ns[2];
        ns[2].node1 = ns[4];
        ns[2].node2 = ns[5];
        ns[4].node2 = ns[6];

        inorderTraverse(root);
        printListFromHead();
        printListFromTail();
    }

    private static void printListFromHead() {
        printList(head, false);
    }

    private static void printListFromTail() {
        printList(tail, true);
    }

    private static void printList(BiNode n, boolean reversed) {
        while (n != null) {
            print(n.value);
            n = reversed ? n.node1 : n.node2;
            if (n != null) print("->");
        }
        println();
    }
}
