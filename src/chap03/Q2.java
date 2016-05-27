package chap03;

import static helpers.Printer.*;

import java.util.Stack;

/**
 * How would you design a stack which, in addition to push
 * and pop, also has a function min which returns the minimum
 * element? Push, pop and min should all operate in O(1) time.
 */
@SuppressWarnings("serial")
public class Q2 /* MinStack */ extends Stack<Integer> {
    private Stack<Integer> min = new Stack<Integer>();

    public void push(int item) {
        if (min.isEmpty() || item < min()) {
            min.push(item);
        }
        super.push(item);
    }

    public Integer pop() {
        int item = super.pop();
        if (item == min()) {
            min.pop();
        }
        return item;
    }

    public Integer min() {
        return min.peek();
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        Q2 stack = new Q2();
        stack.push(2);   println(stack.min());
        stack.push(-1);  println(stack.min());
        stack.push(3);   println(stack.min());
        stack.push(-10); println(stack.min());
        stack.pop();     println(stack.min());
        stack.pop();     println(stack.min());
        stack.push(-20); println(stack.min());
        stack.pop();     println(stack.min());
    }
}
