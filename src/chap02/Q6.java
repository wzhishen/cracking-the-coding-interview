package chap02;

public class Q6 {
    //Given a circular linked list, implement an algorithm which returns the node at the
    //beginning of the loop.
    
    LinkedListNode findBeginning(LinkedListNode head) {
        LinkedListNode fastRunner = head;
        LinkedListNode slowRunner = head;
        
        while (fastRunner != null && fastRunner.next != null) {
            fastRunner = fastRunner.next.next;
            slowRunner = slowRunner.next;
            if (fastRunner == slowRunner) break;
        }
        
        if (fastRunner != slowRunner) { // no loop
            return null;
        }
        
        slowRunner = head;
        while (fastRunner != slowRunner) {
            fastRunner = fastRunner.next;
            slowRunner = slowRunner.next;
        }
        
        return slowRunner;
    }

}
