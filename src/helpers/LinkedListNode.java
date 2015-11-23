package helpers;

import static helpers.Printer.*;

public class LinkedListNode {
    public int data;
    public LinkedListNode next;
    private static int MAX_PRINT_LENGTH = 500;

    public LinkedListNode(int x) {
        data = x;
        next = null;
    }

    public static LinkedListNode buildList(int[] a) {
        if (a == null || a.length == 0) return null;
        LinkedListNode n = new LinkedListNode(a[0]);
        LinkedListNode head = n;
        for (int i = 1; i < a.length; ++i) {
            n.next = new LinkedListNode(a[i]);
            n = n.next;
        }
        return head;
    }

    public static void printList(LinkedListNode n) {
        int i = 0;
        while (n != null) {
            print(n.data + "->");
            n = n.next;
            if (++i > MAX_PRINT_LENGTH) {
                println("[MAX_LEN]");
                return;
            }
        }
        println("NULL");
    }

    public String toString() {
        return String.valueOf(data);
    }
}
