package chap18;

import static helpers.Printer.*;
import static helpers.Trie.*;

/**
 * Given a long string s and an array of smaller strings T, design a
 * method to search s for each small string in T.
 */
public class Q08 {
    private static TrieNode suffixTreeRoot = new TrieNode();

    public static void buildSuffixTree(String s) {
        for (int i = s.length() - 1; i >= 0; --i) {
            addWord(suffixTreeRoot, s.substring(i));
        }
    }

    public static void search(String[] T) {
        for (String t : T) {
            println(getWords(suffixTreeRoot, t));
        }
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        String s = "theveryverylongbananas";
        String[] T = {
            "s",
            "a",
            "ver",
            "verr",
        };

        buildSuffixTree(s);
        search(T);
    }
}
