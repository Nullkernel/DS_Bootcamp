import java.util.*;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;

    TrieNode() {
        isEndOfWord = false;
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }
}

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    private int getValidatedIndex(char ch, int position, String input) {
        char normalized = Character.toLowerCase(ch);
        int index = normalized - 'a';
        if (index < 0 || index >= 26) {
            throw new IllegalArgumentException(
                "Invalid character '" + ch + "' at position " + position
                    + " in \"" + input + "\". Please use letters a-z only."
            );
        }
        return index;
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = getValidatedIndex(word.charAt(i), i, word);
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = getValidatedIndex(word.charAt(i), i, word);
            if (curr.children[index] == null) {
                return false;
            }
            curr = curr.children[index];
        }
        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = getValidatedIndex(prefix.charAt(i), i, prefix);
            if (curr.children[index] == null) {
                return false;
            }
            curr = curr.children[index];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        // Valid examples (uppercase is normalized to lowercase)
        trie.insert("Apple");
        trie.insert("app");
        System.out.println("search(apple): " + trie.search("apple"));
        System.out.println("search(APP): " + trie.search("APP"));
        System.out.println("startsWith(Ap): " + trie.startsWith("Ap"));

        // Invalid example
        try {
            trie.insert("app3");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid example error: " + e.getMessage());
        }
    }
}
