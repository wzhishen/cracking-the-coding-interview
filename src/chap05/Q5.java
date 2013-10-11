package chap05;

public class Q5 {
//    Write a function to determine the number of bits required to convert integer A
//    to integer B.
//    EXAMPLE
//    Input: 31,14 (111111, 1111)
//    Output: 2
    
    int bitsFlipRequired(int a, int b) {
        int cnt = 0;
        int res = a ^ b; //XXX: use XOR!
        for (int i = res; i > 0; i >>= 1) {
            cnt += i & 1;
        }
        return cnt;
    }

}
