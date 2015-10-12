package chap02;

import helpers.LinkedListNode;

/**
 * You have two numbers represented by a linked list, where each node contains a
 * single digit. The digits are stored in reverse order, such that the 1 's digit
 * is at the head of the list. Write a function that adds the two numbers and
 * returns the sum as a linked list.
 */
public class Q5 {
    static LinkedListNode addLists(LinkedListNode n1, LinkedListNode n2) {
        LinkedListNode n = new LinkedListNode(-1);
        LinkedListNode head = n;
        int carry = 0;
        while (n1 != null || n2 != null || carry != 0) {
            int sum = 0;
            if (n1 != null) {
                sum += n1.data;
                n1 = n1.next;
            }
            if (n2 != null) {
                sum += n2.data;
                n2 = n2.next;
            }
            if (carry != 0) {
                sum += carry;
            }
            int digit = sum % 10;
            carry = sum / 10;
            n.next = new LinkedListNode(digit);
            n = n.next;
        }
        return head.next;
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        LinkedListNode l1 = LinkedListNode.buildList(new int[] {2,1,8});
        LinkedListNode l2 = LinkedListNode.buildList(new int[] {8,8,1});
        LinkedListNode.printList(addLists(l1, l2));

        l1 = LinkedListNode.buildList(new int[] {2,9,1});
        l2 = LinkedListNode.buildList(new int[] {8});
        LinkedListNode.printList(addLists(l1, l2));
        LinkedListNode.printList(addLists(l2, l1));
    }
}
