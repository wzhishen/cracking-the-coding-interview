package chap02;

public class Q5 {
    //You have two numbers represented by a linked list, where each node contains a
    //single digit. The digits are stored in reverse order, such that the 1 's digit is at the head
    //of the list. Write a function that adds the two numbers and returns the sum as a
    //linked list.
    
    static LinkedListNode addLists(LinkedListNode n1, LinkedListNode n2) {
        LinkedListNode ret = new LinkedListNode(-1);
        LinkedListNode retHead = ret;
        int carry = 0;
        while (n1 != null || n2 != null || carry != 0) {
            int val1 = 0;
            int val2 = 0;
            if (n1 != null) {
                val1 = n1.data;
                n1 = n1.next;
            }
            if (n2 != null) {
                val2 = n2.data;
                n2 = n2.next;
            }
            int sum = val1 + val2 + carry;
            int digit = sum % 10;
            carry = sum/ 10;
            ret.next = new LinkedListNode(digit);
            ret = ret.next;
        }
        return retHead.next;
    }
    
    //-------------------------------------------
    public static void main(String[] args) {
        LinkedListNode l1 = LinkedListNode.buildList(new int[] {2,1,1});
        LinkedListNode l2 = LinkedListNode.buildList(new int[] {8,8,8});
        LinkedListNode.printList(addLists(l1, l2));
    }

}
