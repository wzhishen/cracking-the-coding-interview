package chap02;

public class Q4 {
    //Write code to partition a linked list around a value x, such that all nodes less than x
    //come before all nodes greater than or equal to x.
    //
    //This version returns a tuple of two partitioned list.
    
    static LinkedListNode[] partition(LinkedListNode n, int x) {
        LinkedListNode list1Head = null;
        LinkedListNode list1Tail = null;
        LinkedListNode list2Head = null;
        LinkedListNode list2Tail = null;
        while (n != null) {
//            LinkedListNode next = n.next;
//            n.next = null;
            if (n.data < x) {
                if (list1Head == null) {
                    list1Head = list1Tail = n;
                }
                else {
                    list1Tail.next = n;
                    list1Tail = n;
                }
            }
            else {
                if (list2Head == null) {
                    list2Head = list2Tail = n;
                }
                else {
                    list2Tail.next = n;
                    list2Tail = n;
                }
            }
            n = n.next;
        }
        if (list1Tail != null) list1Tail.next = null;
        if (list2Tail != null) list2Tail.next = null;
        
//        if (list1Tail == null) return list2Head; //XXX: edge case: list1 is empty
//        list1Tail.next = list2Head;
        return new LinkedListNode[] {list1Head, list2Head};
    }
    
    //-----------------------------------------------------
    public static void main(String[] args) {
        int[] a = {9,2,7,4,6,5,3,8,1};
        LinkedListNode list = LinkedListNode.buildList(a);
        LinkedListNode[] res = partition(list, 6);
        LinkedListNode.printList(res[0]);
        LinkedListNode.printList(res[1]);
    }
}
