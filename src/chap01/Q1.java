package chap01;

public class Q1 {
    // Implement an algorithm to determine if a string has all unique characters. What
    // if you cannot use additional data structures?
    // (assume ASCII str)
    
    // use boolean array
    boolean hasUniqueChars(String str) {
        if (str.length() > 256) return false;
        
        boolean[] charSet = new boolean[256];
        for (int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);
            if (charSet[ch]) return false;
            charSet[ch] = true;
        }
        return true;
    }
    
    // use bit vector
    boolean hasUniqueChars2(String str) {
        if (str.length() > 256) return false;
        
        int bitVector = 0;
        for (int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);
            if ((bitVector & (1 << ch)) > 0) return false;
            bitVector |= (1 << ch);
        }
        return true;
    }
}
