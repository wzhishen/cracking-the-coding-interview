package chap05;

public class Q3 {
//    Given a positive integer, print the next smallest and the next largest number that
//    have the same number of 7 bits in their binary representation.
    
    static int getNext(int n) {
        assert n > 0;
        int numOnes = countNumOnes(n);
        for (int i = n+1; i < Integer.MAX_VALUE;++i) {
            if (countNumOnes(i) == numOnes)
                return i;
        }
        return -1;
    }
    
    static int getPrev(int n) {
        assert n > 0;
        int numOnes = countNumOnes(n);
        for (int i = n-1; i > 0; --i) {
            if (countNumOnes(i) == numOnes)
                return i;
        }
        return -1;
    }
    
    private static int countNumOnes(int n) {
        String binary = getBinary(n);
        int cnt = 0;
        for (int i = 0; i < binary.length(); ++i) {
            if (binary.charAt(i) == '1')
                ++cnt;
        }
        return cnt;
    }
    
    private static String getBinary(int n) {
        StringBuffer sb = new StringBuffer();
        while (n > 0) {
            sb.insert(0, n % 2);
            n /= 2;
        }
        return sb.toString();
    }
    
    //--------------------------------------------------
    public static void main(String[]args) {
        System.out.println(getNext(5)+" "+getPrev(5));
    }

}
