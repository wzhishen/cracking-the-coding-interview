package chap01;

/**
 * Assume you have a method isSubstring which checks if one word is a
 * substring of another. Given two strings, si and s2, write code to check if s2 is
 * a rotation of si using only one call to isSubstring (e.g.,"waterbottle" is a rotation
 * of "erbottlewat").
 * (Assume an empty string is a rotation of an empty string.)
 */
public class Q8 {
    boolean isRotation(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1.length() != s2.length()) return false;
        return isSubstring(s1 + s1, s2);
    }

    private boolean isSubstring(String s1, String s2) {
        return s1.contains(s2);
    }
}
