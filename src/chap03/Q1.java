package chap03;

public class Q1 {
    //Describe how you could use a single array to implement three stacks.
    
    final int STACK_SIZE = 100;
    int[] buffer = new int[3 * STACK_SIZE];
    int[] stackPointer = {-1, -1, -1}; // relative index
    
    void push(int stackNum, int x) {
        if (isFull(stackNum))
            throw new IllegalArgumentException("Stack is full!");
        ++stackPointer[stackNum];
        buffer[getAbsIndex(stackNum)] = x;
    }
    
    int pop(int stackNum) {
        int ret = peek(stackNum);
        --stackPointer[stackNum];
        return ret;
    }
    
    int peek(int stackNum) {
        if (isEmpty(stackNum))
            throw new IllegalArgumentException("Stack is empty!");
        return buffer[getAbsIndex(stackNum)];
    }
    
    boolean isEmpty(int stackNum) {
        return stackPointer[stackNum] == -1;
    }
    
    boolean isFull(int stackNum) {
        return stackPointer[stackNum] == STACK_SIZE - 1;
    }
    
    private int getAbsIndex(int stackNum) {
        return stackNum * STACK_SIZE + stackPointer[stackNum];
    }

}
