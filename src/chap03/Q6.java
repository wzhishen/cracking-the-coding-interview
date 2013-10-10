package chap03;

import java.util.Stack;

public class Q6 {
    //Write a program to sort a stack in ascending order (with biggest items on top).
    //You may use at most one additional stack to hold items, but you may not copy the
    //elements into any other data structure (such as an array). The stack supports the
    //following operations: push, pop, peek, and isEmpty.
    
    // This algorithm is 0(N2) time and 0(N) space.
    Stack<Integer> sortStack(Stack<Integer> s) {
        Stack<Integer> ret = new Stack<Integer>();
        while (!s.isEmpty()) {
            int val = s.pop();
            while (!ret.isEmpty() && ret.peek() > val) {
                s.push(ret.pop());
            }
            ret.push(val);
        }
        return ret;
    }
}
