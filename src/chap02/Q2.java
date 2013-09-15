package chap02;

public class Q2 {
    //Implement an algorithm to find the kth to last element of a singly linked list.
    
    LinkedListNode nthToLast(LinkedListNode head, int k) {
        if (k <= 0) return null; //XXX
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;
        
        for (int i = 0; i < k; ++i) {
            if (p2 == null) return null; //XXX
            p2 = p2.next;
        }
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        
        return p1;
    }
}
