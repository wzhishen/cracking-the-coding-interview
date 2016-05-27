package chap01;

import static helpers.Printer.*;

/**
 * Write a method to replace all spaces in a string with'%20'. You may assume that
 * the string has sufficient space at the end of the string to hold the additional
 * characters, and that you are given the "true" length of the string. (Note: if
 * implementing in Java, please use a character array so that you can perform this
 * operation in place.)
 * EXAMPLE
 * Input:  "Mr John Smith    "
 * Output: "Mr%20John%20Smith"
 */
public class Q4 {
    static void replaceSpaces(char[] str, int length) {
        // 1st scan: count spaces
        int cnt = 0;
        for (char ch : str) {
            if (ch == ' ') ++cnt;
        }

        // 2nd scan: replace spaces
        int p = length + 2 * cnt;
        str[p] = '\0'; //XXX
        --p;
        for (int i = length - 1; i >= 0; --i) {
            if (str[i] == ' ') {
                str[p--] = '0';
                str[p--] = '2';
                str[p--] = '%';
            } else {
                str[p--] = str[i];
            }
        }
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        char[] str = {'a','b',' ','c',' ','d','\0','\0','\0','\0','\0','\0','\0'};
        replaceSpaces(str, 6);
        printArray(str);
    }
}
