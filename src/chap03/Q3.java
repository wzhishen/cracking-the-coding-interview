package chap03;

import java.util.LinkedList;
import java.util.Stack;

public class Q3 /* class SetOfStacks */ {
    //Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore,
    //in real life, we would likely start a new stack when the previous stack exceeds some
    //threshold. Implement a data structure SetOfStacks that mimics this. SetOf-
    //Stacks should be composed of several stacks and should create a new stack once
    //the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.
    //pop () should behave identically to a single stack (that is, pop () should return the
    //same values as it would if there were just a single stack).
    //FOLLOW UP
    //Implement a function popAt(int index) which performs a pop operation on a
    //specific sub-stack.
    
    final int STACK_SIZE = 2;
    LinkedList<Stack<Integer>> stacks = new LinkedList<Stack<Integer>>();
    
    void push(int x) {
        if (stacks.isEmpty() || isFull(stacks.getLast()))
            stacks.add(new Stack<Integer>());
        stacks.getLast().push(x);
    }
    
    int pop() {
        if (stacks.isEmpty())
            throw new IllegalStateException("Stacks are empty!");
        Stack<Integer> last = stacks.getLast();
        int ret = last.pop();
        if (last.isEmpty())
            stacks.remove(last);
        return ret;
    }
    
    int popAt(int index) {
        if (stacks.isEmpty())
            throw new IllegalStateException("Stacks are empty!");
        if (index < 0 || index >= stacks.size())
            throw new IllegalArgumentException("Illegal index!");
        
        int ret = stacks.get(index).pop();
        for (int i = index + 1; i < stacks.size(); ++i) {
            stacks.get(i - 1).push(stacks.get(i).remove(0));
        }
        // XXX: after rolling over, last stack may be empty, so delete it
        if (stacks.getLast().isEmpty())
            stacks.removeLast();
        
        return ret;
    }
    
    boolean isFull(Stack<Integer> stack) {
        return stack.size() == STACK_SIZE;
    }
    
    //---------------------------------------------------------
    public static void main(String[]args) {
        Q3 stacks = new Q3();
        stacks.push(1);stacks.push(2);stacks.push(3);
        stacks.push(4);stacks.push(5);stacks.push(6);
        stacks.push(7);stacks.push(8);stacks.push(9);
        
        stacks.popAt(1);
        for (Stack<Integer> stack : stacks.stacks) {
            for (int i : stack) {
                System.out.print(i + " ");
            }
            System.out.println("[TOP]");
        }
    }
}
