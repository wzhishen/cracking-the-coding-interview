package chap05;

public class Q2 {
    //Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double, print
    //the binary representation. If the number cannot be represented accurately in binary
    //with at most 32 characters, print "ERROR."
    
    //To print the decimal part, we can multiply by 2 and check if 2n is greater than or equal
    //to 1.
    
    static String printBinary(double n) {
        if (n <= 0 || n >= 1) return "ERROR";
        StringBuffer bin = new StringBuffer("0.");
        while (n > 0) {
            n *= 2;
            if (n >= 1) { //XXX: equal to 1: terminating condition!
                bin.append("1");
                n -= 1;
            }
            else {
                bin.append("0");
            }
            if (bin.length() > 32) return "ERROR";
        }
        return bin.toString();
    }
    
    //--------------------------------------
    public static void main(String[]args) {
        System.out.println(printBinary(0.25));
    }

}
