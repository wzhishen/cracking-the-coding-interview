package chap02;

public class Q3 {
    //Implement an algorithm to delete a node in the middle of a singly linked list, given
    //only access to that node.
    
    boolean deleteNode(LinkedListNode n) {
        //XXX: fail if the node is the last element
        if (n == null || n.next == null) return false;
        
        n.data = n.next.data;
        n.next = n.next.next;
        return true;
    }
}
