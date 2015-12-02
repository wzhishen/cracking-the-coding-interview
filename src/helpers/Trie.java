package helpers;

import static helpers.Printer.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Trie {
    public static class TrieNode {
        public char character;
        public boolean isWord;
        public HashMap<Character, TrieNode> children;

        public TrieNode(char ch) {
            character = ch;
            isWord = false;
            children = new HashMap<Character, TrieNode>();
        }
        public TrieNode() {
            this('\0');
        }
    }

    public static void addWord(TrieNode n, String word) {
        if (word == null || word.isEmpty()) return;
        char[] characters = word.toCharArray();
        for (char ch: characters) {
            if (!n.children.containsKey(ch)) {
                n.children.put(ch, new TrieNode(ch));
            }
            n = n.children.get(ch);
        }
        n.isWord = true;
    }

    public static ArrayList<String> getAllWords(TrieNode n) {
        return getWords(n, "");
    }

    public static boolean hasPrefix(TrieNode n, String prefix) {
        return has(n, prefix, false);
    }

    public static boolean hasWord(TrieNode n, String prefix) {
        return has(n, prefix, true);
    }

    private static boolean has(TrieNode n, String prefix, boolean checkHasWord) {
        if (prefix == null) return false;
        char[] characters = prefix.toCharArray();
        for (char ch: characters) {
            if (!n.children.containsKey(ch)) return false;
            n = n.children.get(ch);
        }
        if (checkHasWord) {
            return n.isWord;
        } else {
            return true;
        }
    }

    public static ArrayList<String> getWords(TrieNode n, String prefix) {
        if (prefix == null) return null;
        ArrayList<String> result = new ArrayList<String>();
        char[] characters = prefix.toCharArray();
        for (char ch: characters) {
            if (!n.children.containsKey(ch)) return result;
            n = n.children.get(ch);
        }
        getWords(n, prefix, result);
        return result;
    }

    private static void getWords(TrieNode n, String word, ArrayList<String> result) {
        if (n.isWord) result.add(word);
        for (char ch : n.children.keySet()) {
            getWords(n.children.get(ch), word + ch, result);
        }
    }

    //TEST----------------------------------
    public static void main(String[] args) {
        TrieNode root = new TrieNode();
        addWord(root, "dog");
        addWord(root, "dig");
        addWord(root, "");
        addWord(root, null);
        addWord(root, "dogman");
        addWord(root, "do");
        addWord(root, "d");
        addWord(root, "apple");
        addWord(root, "application");
        addWord(root, "algorithm");
        printWords(root, "ap");
        printWords(root, "d");
        printWords(root, "none");
        printAllWords(root);
    }

    private static void printWords(TrieNode n, String prefix) {
        printf("getWords for %s: ", prefix);
        println(getWords(n, prefix));
    }

    private static void printAllWords(TrieNode n) {
        printf("getAllWords: ");
        println(getAllWords(n));
    }
}
