package chap03;

import java.util.Stack;

public class Q5 {
    //Implement a MyQueue class which implements a queue using two stacks.
    
    Stack<Integer> headStack = new Stack<Integer>();
    Stack<Integer> tailStack = new Stack<Integer>();
    
    void enqueue(int x) {
        tailStack.push(x);
    }
    
    int dequeue() {
        refactor();
        return headStack.pop();
    }
    
    int peek() {
        refactor();
        return headStack.peek();
    }
    
    int size() {
        return headStack.size() + tailStack.size();
    }
    
    private void refactor() {
        if (headStack.isEmpty())
            while (!tailStack.isEmpty()) {
                headStack.push(tailStack.pop());
            }
        if (headStack.isEmpty())
            throw new IllegalStateException("The queue is empty!");
    }
    
    //-----------------------------------------------------
    public static void main(String[]args) {
        Q5 q = new Q5();
        q.enqueue(1);q.enqueue(2);q.enqueue(3);q.enqueue(4);q.enqueue(5);
        q.printQueue();
        
        q.peek();
        q.dequeue();
        q.printQueue();
        
        q.enqueue(6);q.enqueue(7);q.enqueue(8);
        q.printQueue();
    }
    
    private void printQueue() {
        System.out.print("[HEAD] ");
        for (int i = headStack.size() - 1; i >= 0; --i)
            System.out.print(headStack.get(i) + " ");
        for (int i : tailStack)
            System.out.print(i + " ");
        System.out.print(" [TAIL]\n");
    }
}
