package chap03;

import static helpers.Printer.*;

import java.util.Arrays;
import java.util.Stack;

/**
 * Write a program to sort a stack in ascending order (with
 * biggest items on top). You may use at most one additional
 * stack to hold items, but you may not copy the elements into
 * any other data structure (such as an array). The stack supports
 * the following operations: push, pop, peek, and isEmpty.
 */
public class Q6 {
    // O(n^2) time and O(n) space
    public static Stack<Integer> sortStack(Stack<Integer> stack) {
        Stack<Integer> result = new Stack<Integer>();
        while (!stack.isEmpty() ) {
            int item = stack.pop();
            while (!result.isEmpty() && item < result.peek()) {
                stack.push(result.pop());
            }
            result.push(item);
        }
        return result;
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        Integer[] a = {2,6,5,4,1,3,8,7};
        Stack<Integer> stack = new Stack<Integer>();
        stack.addAll(Arrays.asList(a));
        print(sortStack(stack));
    }
}
