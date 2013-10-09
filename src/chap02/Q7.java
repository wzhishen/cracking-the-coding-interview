package chap02;

import java.util.Stack;

public class Q7 {
    //implement a function to check if a linked list is a palindrome.
    //like 0 -> 1 -> 2 -> 1 - > 0
    
    static boolean isPalindrome(LinkedListNode head) {
        if (head == null) return false;
        LinkedListNode fastRunner = head;
        LinkedListNode slowRunner = head;
        Stack<Integer> vals = new Stack<Integer>();
        
        while (fastRunner != null && fastRunner.next != null) {
            vals.push(slowRunner.data);
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
        }
        
        // handle odd nodes
        if (fastRunner != null)
            slowRunner = slowRunner.next;
        
        while (slowRunner != null) {
            if (slowRunner.data != vals.pop()) 
                return false;
            slowRunner = slowRunner.next;
        }
        return true;
    }
    
    //----------------------------------------------------
    public static void main(String[] args) {
        int[] a = {1,2,3,4,4,3,2,1};
        System.out.println(isPalindrome(LinkedListNode.buildList(a)));
    }
}
