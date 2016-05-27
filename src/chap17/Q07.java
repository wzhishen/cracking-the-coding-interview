package chap17;

import static helpers.Printer.*;

/**
 * Given any integer, print an English phrase that describes
 * the integer (e.g., "One Thousand, Two Hundred Thirty Four").
 */
public class Q07 {
    private static String[] digits = {"One", "Two", "Three","Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static String[] tens = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static String[] bigs = {"", "Thousand", "Million", "Billion"};

    public static String intToString(int n) {
        if (n == 0) return "Zero";
        if (n < 0) return "Negative " + intToString(-n);
        String ret = "";
        int i = 0;
        while (n > 0) {
            String hundredSegment = convertHundred(n % 1000);
            if (!hundredSegment.isEmpty()) {
                ret = hundredSegment + bigs[i] + " " + ret;
            }
            n /= 1000;
            ++i;
        }
        return ret.trim();
    }

    private static String convertHundred(int n) {
        String ret = "";
        if (n >= 100) {
            ret += digits[n / 100 - 1] + " Hundred ";
            n %= 100;
        }
        if (n >= 20) {
            ret += tens[n / 10 - 2] + " ";
            n %= 10;
        }
        if (n >= 10) {
            ret += teens[n % 10] + " ";
            n = 0;
        }
        if (n > 0) {
            ret += digits[n - 1] + " ";
        }
        return ret;
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        println(intToString(21));
        println(intToString(121));
        println(intToString(789702501));
        println(intToString(-1000000));
        println(intToString(-1000000200));
    }

}
