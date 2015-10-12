package chap02;

import static helpers.Printer.*;

import helpers.LinkedListNode;

/**
 * Given a circular linked list, implement an algorithm which returns
 * the node at the beginning of the loop.
 */
public class Q6 {
    static LinkedListNode findBeginning(LinkedListNode head) {
        LinkedListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        if (fast == null || fast.next == null) return null;
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        int[] list = {1,2,3,4,5,6};
        LinkedListNode n = LinkedListNode.buildList(list), head = n;
        println(findBeginning(head));

        while (n.next != null) n = n.next;
        n.next = head.next.next.next;
        println(findBeginning(head));
    }
}
