package chap02;

public class E2 {
    public LinkedListNode merge(LinkedListNode n1, LinkedListNode n2) {
        if (n1 == null) return n2;
        if (n2 == null) return n1;
        LinkedListNode retHead = null;
        LinkedListNode retTail = null;
        while (n1 != null && n2 != null) {
            if (n1.data < n2.data) {
                if (retHead == null) {
                    retHead = retTail = n1;
                }
                else {
                    retTail.next = n1;
                    retTail = n1;
                }
                n1 = n1.next;
            }
            else {
                if (retHead == null) {
                    retHead = retTail = n2;
                }
                else {
                    retTail.next = n2;
                    retTail = n2;
                }
                n2 = n2.next;
            }
        }
        if (n1 != null) retTail.next = n1;
        else if (n2 != null) retTail.next = n2;
        return retHead;
    }
    
  //-----------------------------------------------------
    public static void main(String[] args) {
        LinkedListNode list1 = LinkedListNode.buildList(new int[] {1,2,3,5,7,8,10});
        LinkedListNode list2 = LinkedListNode.buildList(new int[] {2,4,6,7,9,11,12,15});
        LinkedListNode res = new E2().merge(list1, list2);
        LinkedListNode.printList(res);
    }
}
