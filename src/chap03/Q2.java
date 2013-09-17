package chap03;

import java.util.Stack;

public class Q2 extends Stack<Integer> {
    //How would you design a stack which, in addition to push and pop, also has a
    //function min which returns the minimum element? Push, pop and min should
    //all operate in O(1) time.
    
    Stack<Integer> min = new Stack<Integer>();
    
    public void push(int x) {
        if (x < min())
            min.push(x);
        super.push(x);
    }
    
    public Integer pop() {
        int ret = super.pop();
        if (ret == min())
            min.pop();
        return ret;
    }
    
    public int min() {
        if (min.empty())
            return Integer.MAX_VALUE;
        return min.peek();
    }
}
