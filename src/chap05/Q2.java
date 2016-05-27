package chap05;

import static helpers.Printer.*;

/**
 * Given a real number between 0 and 1 (e.g., 0.72) that is passed
 * in as a double, print the binary representation. If the number
 * cannot be represented accurately in binary with at most 32
 * characters, print "ERROR".
 */
public class Q2 {
    /* Key:
     * To print the decimal part, multiply it by 2,
     * if 2*n is greater than or equal to 1: append bit 1
     * else: append bit 0
     */
    public static String printBinary(double n) {
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        while (n > 0) {
            if (n * 2 >= 1) {
                sb.append(1);
                n = n * 2 - 1;
            } else {
                sb.append(0);
                n *= 2;
            }
            if (sb.length() > 32) {
                return "ERROR(" + sb.toString() + ")";
            }
        }
        return sb.toString();
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        println(printBinary(0.0));
        println(printBinary(0.25));
        println(printBinary(0.025));
        println(printBinary(0.75));
        println(printBinary(0.750001));
    }
}
