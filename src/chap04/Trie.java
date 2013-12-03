package chap04;

import java.util.ArrayList;

public class Trie {
    
    public static TrieNode buildTrie() {
        return new TrieNode();
    }
    
    public static void addWord(String word, TrieNode root) {
        if (root == null) throw new IllegalArgumentException();
        char[] letters = word.toCharArray();
        TrieNode n = root;
        for (char letter : letters) {
            if (!n.children.containsKey(letter)) {
                n.children.put(letter, new TrieNode(letter));
            }
            n = n.children.get(letter);
        }
        n.isWord = true;
    }
    
    public static ArrayList<String> getAllWords(String prefix, TrieNode root) {
        if (root == null) throw new IllegalArgumentException();
        ArrayList<String> ret = new ArrayList<String>();
        char[] letters = prefix.toCharArray();
        TrieNode n = root;
        for (char letter : letters) {
            if (!n.children.containsKey(letter)) return ret;
            n = n.children.get(letter);
        }
        getAllWords(prefix, n, ret);
        return ret;
    }
    
    //DFS
    private static void getAllWords(String word, TrieNode root, ArrayList<String> ret) {
        if (root.isWord) ret.add(word);
        for (char letter : root.children.keySet()) {
            getAllWords(word + letter, root.children.get(letter), ret);
        }
    }
    
    public static void main(String[] args) {
        TrieNode root = buildTrie();
        addWord("dog", root);
        addWord("dig", root);
        addWord("dogman", root);
        addWord("do", root);
        addWord("apple", root);
        addWord("application", root);
        System.out.println(getAllWords("d", root));
    }
}
