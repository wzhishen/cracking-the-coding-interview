package chap07;

public class Q4 {
//    Write methods to implement the multiply, subtract, and divide operations for
//    integers. Use only the add operator.
    
    static int negate(int n) {
        int neg = 0;
        int d = n < 0 ? 1 : -1;
        while (n != 0) {
            n += d;
            neg += d;
        }
        return neg;
    }
    
    static int abs(int n) {
        return n < 0 ? negate(n) : n;
    }
    
    public static int subtract(int a, int b) {
        return a + negate(b);
    }
    
    public static int multiply(int a, int b) {
        if (abs(a)<abs(b)) // make it faster
            return multiply(b, a);
        int sum = 0;
        for (int i = 0; i < abs(b); ++i) {
            sum += a;
        }
        return b < 0 ? negate(sum) : sum;
    }
    
    public static int divide(int a, int b) {
        if (b == 0)
            throw new ArithmeticException("Zero divisor!");
        int absa = abs(a);
        int absb = abs(b);
        
        int sum = 0;
        int x = 0;
        while ((sum += absb) <= absa) {
            ++x;
        }
        return (a > 0) != (b > 0) ? negate(x) : x;
    }
    
    //--------------------------------------
    public static void main(String[]args) {
        System.out.println(abs(4));
        System.out.println(divide(45,2));
    }
}
