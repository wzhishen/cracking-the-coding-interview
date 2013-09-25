package chap17;

public class Q01 {
//    Write a function to swap a number in place (that is, without temporary variables).
    
    void swap(int a, int b) {
        a = a - b; // diff = a - b
        b = b + a; // now b is b + diff, which is a
        a = b - a; // now a is a - diff, which is b
    }
    
    // Fact:
    // if diff = a XOR b, then
    // b is a XOR diff,
    // a is b XOR diff.
    void swap2(int a, int b) {
        a = a ^ b; // diff = a XOR b
        b = b ^ a; // now b is b XOR diff, which is a
        a = b ^ a; // now a is a XOR diff, which is b
    }

}
