package chap04;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    char character;
    boolean isWord;
    Map<Character, TrieNode> children;
    
    public TrieNode(char ch) {
        character = ch;
        isWord = false;
        children = new HashMap<Character, TrieNode>();
    }
    
    public TrieNode() {
        this('\0');
    }
}
