package chap17;

public class Q04 {
//    Write a method which finds the maximum of two numbers. You should not use
//    if-else or any other comparison operator.
//    
//    SOLUTION:
//    if..else... can be translated to:
//    RESULT = EXPR_1 * COND + EXPR_2 * flip(COND), where COND with value 1 (0) 
//    represents true (false).
    
    static int flip(int i) {
        return 1 ^ i;
    }
    
    // returns 1 if positive, 0 otherwise
    static int sign(int n) {
        return flip((n >> 31) & 1); //check most significant bit: neg -> 1, pos -> 0
    }
    
    static int max(int a, int b) {
        int k = sign(a - b);
        return a * k + b * flip(k);
    }
    
    // consider overflow of a - b
    static int max2(int a, int b) {
        int cond1 = sign(a) ^ sign(b);
        int cond2 = sign(a) * cond1 + sign(a - b) * flip(cond1);
        return a * cond2 + b * flip(cond2);
    }
    //----------------------------------------
    public static void main(String[]args) {
        System.out.println(max(-1, 5));
        System.out.println(max2(-1, 5));
    }

}
