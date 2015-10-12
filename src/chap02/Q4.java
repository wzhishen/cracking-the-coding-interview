package chap02;

import helpers.LinkedListNode;

/**
 * Write code to partition a linked list around a value x, such that all
 * nodes less than x come before all nodes greater than or equal to x.
 */
public class Q4 {
    static LinkedListNode partition(LinkedListNode n, int x) {
        LinkedListNode head1 = null, tail1 = null,
                       head2 = null, tail2 = null;
        while (n != null) {
            if (n.data < x) {
                if (head1 == null) {
                    head1 = tail1 = n;
                } else {
                    tail1.next = n;
                    tail1 = n;
                }
            } else {
                if (head2 == null) {
                    head2 = tail2 = n;
                } else {
                    tail2.next = n;
                    tail2 = n;
                }
            }
            n = n.next;
        }
        // Trim tails
        if (tail1 != null) tail1.next = null;
        if (tail2 != null) tail2.next = null;

        // List1 is empty
        if (head1 == null) return head2;
        tail1.next = head2;
        return head1;
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        int[] list = {9,2,7,4,6,5,3,8,1};
        LinkedListNode n = LinkedListNode.buildList(list);
        n = LinkedListNode.buildList(list);
        LinkedListNode.printList(partition(n, 6));
        n = LinkedListNode.buildList(list);
        LinkedListNode.printList(partition(n, 0));
        n = LinkedListNode.buildList(list);
        LinkedListNode.printList(partition(n, 100));
    }
}
