package chap01;

import java.util.Arrays;

public class Q3 {
    // Given two strings, write a method to decide if one is a permutation of the other.
    // (assume comparison is case-sensitive, space-significant, ASCII-based)

    boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        
        int[] charCount = new int[256];
        for (int i = 0; i < s1.length(); ++i) {
            ++charCount[s1.charAt(i)];
        }
        
        for (int i = 0; i < s2.length(); ++i) {
            if (--charCount[s2.charAt(i)] < 0)
                return false;
        }
        return true;
    }
    
    boolean isPermutation2(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        return new String(charArray1).equals(new String(charArray2));
    }
}
