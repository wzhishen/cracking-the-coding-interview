package chap02;

import static helpers.Printer.*;

import helpers.LinkedListNode;

/**
 * Implement an algorithm to delete a node in the middle of a singly linked list,
 * given only access to that node.
 */
public class Q3 {
    static boolean deleteNode(LinkedListNode n) {
        //XXX: fail if the node is the last element.
        if (n == null || n.next == null) return false;
        n.data = n.next.data;
        n.next = n.next.next;
        return true;
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        int[] list = {3,2,1,0};
        LinkedListNode head = LinkedListNode.buildList(list);
        LinkedListNode n1 = head.next,
                       n2 = head.next.next.next,
                       n3 = null;
        println("DELETE " + n3 + ": " + deleteNode(n3));
        LinkedListNode.printList(n3);
        println("DELETE " + n2 + ": " + deleteNode(n2));
        LinkedListNode.printList(n2);
        println("DELETE " + n1 + ": " + deleteNode(n1));
        LinkedListNode.printList(n1);
    }
}
