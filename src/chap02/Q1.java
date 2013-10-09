package chap02;

import java.util.HashSet;

public class Q1 {
    //Write code to remove duplicates from an unsorted linked list.
    //FOLLOW UP
    //How would you solve this problem if a temporary buffer is not allowed?
    
    // with extra space
    void removeDuplicates(LinkedListNode n) {
        HashSet<Integer> set = new HashSet<Integer>();
        LinkedListNode prev = null;
        while (n != null) {
            if (set.contains(n.data)) {
                prev.next = n.next;
            }
            else {
                set.add(n.data);
                prev = n;
            }
            n = n.next;
        }
    }
    
    //without extra space
    void removeDuplicates2(LinkedListNode n) {
        LinkedListNode curr = n;
        while (curr != null) {
            LinkedListNode runner = n;
            while (runner != null) {
                if (runner.next != null && runner.next.data == curr.data) {
                    runner.next = runner.next.next;
                }
                else {//XXX
                    runner = runner.next;
                }
            }
            curr = curr.next;
        }
    }
}
