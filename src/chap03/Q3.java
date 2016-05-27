package chap03;

import static helpers.Printer.*;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Imagine a (literal) stack of plates. If the stack gets too high, it
 * might topple. Therefore, in real life, we would likely start a new
 * stack when the previous stack exceeds some threshold. Implement a
 * data structure SetOfStacks that mimics this. SetOfStacks should be
 * composed of several stacks and should create a new stack once the
 * previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.pop()
 * should behave identically to a single stack (that is, pop() should
 * return the same values as it would if there were just a single stack).
 *
 * FOLLOW UP
 * Implement a function popAt(int index) which performs a pop operation
 * on a specific sub-stack.
 */
public class Q3 {
    private static final int STACK_SIZE = 3;
    private LinkedList<Stack<Integer>> stacks = new LinkedList<Stack<Integer>>();

    public void push(int item) {
        if (stacks.isEmpty() || stacks.getLast().size() >= STACK_SIZE) {
            Stack<Integer> stack = new Stack<Integer>();
            stack.push(item);
            stacks.add(stack);
        } else {
            stacks.getLast().push(item);
        }
    }

    public Integer pop() {
        if (stacks.isEmpty())
            throw new IllegalStateException("Stacks are empty!");
        Stack<Integer> last = stacks.getLast();
        int item = last.pop();
        if (last.isEmpty())
            stacks.removeLast();
        return item;
    }

    public Integer popAt(int index) {
        if (stacks.isEmpty())
            throw new IllegalStateException("Stacks are empty!");
        if (index < 0 || index >= stacks.size())
            throw new IllegalArgumentException("Invalid index!");
        int item = stacks.get(index).pop();
        for (int i = index; i < stacks.size() - 1; ++i) {
            Stack<Integer> curr = stacks.get(i);
            Stack<Integer> next = stacks.get(i + 1);
            curr.push(next.remove(0));
        }
        if (stacks.getLast().isEmpty())
            stacks.removeLast();
        return item;
    }

    public void printStacks() {
        for (Stack<Integer> stack : stacks) {
            for (int item : stack)
                print(item + " ");
            println("[TOP]");
        }
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        Q3 setOfStacks = new Q3();
        setOfStacks.push(1); setOfStacks.push(2); setOfStacks.push(3);
        setOfStacks.push(4); setOfStacks.push(5); setOfStacks.push(6);
        setOfStacks.push(7); setOfStacks.push(8); setOfStacks.push(9);
        setOfStacks.printStacks();
        println();
        setOfStacks.popAt(1);
        setOfStacks.popAt(0);
        setOfStacks.printStacks();
    }
}
