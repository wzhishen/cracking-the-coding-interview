package chap01;

public class Q4 {
    //Write a method to replace all spaces in a string with'%20'. You may assume that
    //the string has sufficient space at the end of the string to hold the additional
    //characters, and that you are given the "true" length of the string. (Note: if implementing
    //in Java, please use a character array so that you can perform this operation
    //in place.)
    //EXAMPLE
    //Input: "Mr John Smith
    //Output: "Mr%20Dohn%20Smith"
    
    void replaceSpaces(char[] str, int length) {
        // 1st scan: count spaces
        int cnt = 0;
        for (char ch : str) {
            if (ch == ' ') ++cnt;
        }
        
        // 2nd scan: replace spaces
        int newLength = length + 2 * cnt;
        str[newLength] = '\0'; //XXX
        for (int i = str.length - 1; i >= 0; --i) {
            if (str[i] == ' ') {
                str[newLength - 1] = '0';
                str[newLength - 2] = '2';
                str[newLength - 3] = '%';
                newLength -= 3;
            }
            else {
                str[newLength - 1] = str[i];
                --newLength;
            }
        }
    }

}
