package chap02;

import static helpers.Printer.*;

import helpers.LinkedListNode;

/**
 * Implement an algorithm to find the kth to last element of a singly linked list.
 */
public class Q2 {
    //Returns nearest node if index out of bounds.
    static LinkedListNode nthToLast(LinkedListNode head, int k) {
        LinkedListNode n = head, r = head;
        for (int i = 0; i < k; ++i) {
            r = r.next;
            if (r == null) return n;
        }
        while (r.next != null) {
            r = r.next;
            n = n.next;
        }
        return n;
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        int[] list = {5,4,3,2,1,0};
        LinkedListNode n = LinkedListNode.buildList(list);
        println(nthToLast(n, 0));
        println(nthToLast(n, 3));
        println(nthToLast(n, 5));
        println(nthToLast(n, 6));
        println(nthToLast(n, -100));
        println(nthToLast(n, 100));
    }
}
