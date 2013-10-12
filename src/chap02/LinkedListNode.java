package chap02;

public class LinkedListNode {
    int data;
    LinkedListNode next;
    
    public LinkedListNode(int x) {
        data = x;
        next = null;
    }
    
    public static LinkedListNode buildList(int[] a) {
        LinkedListNode n = new LinkedListNode(a[0]);
        LinkedListNode head = n;
        for (int i = 1; i < a.length; ++i) {
            n.next = new LinkedListNode(a[i]);
            n = n.next;
        }
        return head;
    }
    
    public static void printList(LinkedListNode n) {
        if (n == null) System.out.print("NULL");
        while (n != null) {
            System.out.print(n.data + "->");
            n = n.next;
        }
        System.out.println();
    }
}
