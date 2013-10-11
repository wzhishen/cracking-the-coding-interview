package chap01;

public class E1 {
    //determines whether a String is a palindrome
    
    static boolean isPalindrome(String s) {// better
        if (s == null) return false;
        for (int i = 0; i < s.length() / 2; ++i) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }
        return true;
    }
    
    static boolean isPalindrome2(String s) {
        if (s == null) return false;
        if (s.isEmpty() || s.length() == 1) return true;
        
        int head = 0;
        int tail = s.length() - 1;
        while (head != tail && head + 1 != tail) {
            if (s.charAt(head) != s.charAt(tail))
                return false;
            ++head;
            --tail;
        }
        return s.charAt(head) == s.charAt(tail);
    }
    
    public static void main(String[]args) {
        System.out.println(isPalindrome("121"));
        System.out.println(isPalindrome("a1g2a"));
    }

}
