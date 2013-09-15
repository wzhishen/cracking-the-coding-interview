package chap02;

public class Q0 {
    public static LinkedListNode reverseList(LinkedListNode n) {
        if (n == null || n.next == null) return n;
        LinkedListNode head = n;
        LinkedListNode curr =  head.next;
        LinkedListNode next = curr.next;
        head.next = null;
        while (true) {
            curr.next = head;
            head = curr;
            curr = next;
            if (curr == null) break;
            next = curr.next;
        }
        return head;
    }
    
    public static void main(String[]args) {
        LinkedListNode list = LinkedListNode.buildList(new int[] {1,2,3,4,5});
        LinkedListNode.printList(list);
        LinkedListNode.printList(reverseList(list));
    }
}
