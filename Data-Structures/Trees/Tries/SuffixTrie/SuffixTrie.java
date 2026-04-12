import java.util.*;

class SuffixNode {
    SuffixNode[] children = new SuffixNode[26];
    boolean isEnd;
    SuffixNode() {
        isEnd = false;
    }
}
public class SuffixTrie {
    SuffixNode root;
    public SuffixTrie() {
        root = new SuffixNode();
    }
    public void insert(String word) {
        SuffixNode curr = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new SuffixNode();
            }
            curr = curr.children[index];
        }
        curr.isEnd = true;
    }
    public void buildSuffixTrie(String text) {
        for (int i = 0; i < text.length(); i++) {
            insert(text.substring(i));
        }
    }
    public boolean search(String pattern) {
        SuffixNode curr = root;
        for (char ch : pattern.toCharArray()) {
            int index = ch - 'a';
            if (curr.children[index] == null) {
                return false;
            }
            curr = curr.children[index];
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SuffixTrie trie = new SuffixTrie();
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        trie.buildSuffixTrie(text);
        System.out.print("Enter substring to Search: ");
        String pattern = sc.nextLine();
        System.out.println("Substring exists: " + trie.search(pattern));
    }
}
