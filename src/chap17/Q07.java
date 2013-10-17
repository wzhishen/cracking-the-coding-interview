package chap17;

public class Q07 {
//    Given any integer, print an English phrase that describes the integer (e.g., "One
//    Thousand, Two Hundred Thirty Four").
    
    static String[] digits = {"One", "Two", "Three","Four", "Five", "Six", "Seven", "Eight", "Nine"};
    static String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    static String[] tens = {"", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    static String[] bigs = {"", "Thousand", "Million", "Billion"};
    
    static String intToString(int n) {
        if (n == 0) return "Zero";
        if (n < 0) return "Negative " + intToString(-n);
        String ret = "";
        int cnt = 0;
        while (n > 0) {
            ret = convertHundred(n % 1000) + bigs[cnt] + " " + ret;
            n /= 1000;
            ++cnt;
        }
        return ret;
    }
    
    static private String convertHundred(int n) {
        String ret = "";
        if (n >= 100) {
            ret += digits[n / 100 - 1] + " Hundred ";
            n %= 100;
        }
        if (n >= 20) {
            ret += tens[n / 10 - 1] + " ";
            n %= 10;
        }
        if (n >= 10) {
            ret += teens[n - 10] + " ";
            n = 0;
        }
        if (n > 0) {
            ret += digits[n - 1] + " ";
        }
        return ret;
    }
    
    //---------------------------------------
    public static void main(String[]args) {
        System.out.println(intToString(21));
    }

}
