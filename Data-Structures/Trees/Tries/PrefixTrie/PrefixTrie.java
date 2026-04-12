import java.util.*;

class PrefixNode {
    PrefixNode[] children = new PrefixNode[26];
    int count; 
    PrefixNode() {
        count = 0;
    }
}
public class PrefixTrie {
    PrefixNode root;
    public PrefixTrie() {
        root = new PrefixNode();
    }
    public void insert(String word) {
        PrefixNode curr = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new PrefixNode();
            }
            curr = curr.children[index];
            curr.count++;
        }
    }
    public int countPrefix(String prefix) {
        PrefixNode curr = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (curr.children[index] == null) {
                return 0;
            }
            curr = curr.children[index];
        }
        return curr.count;
    }
    public static void main(String[] args) {
        PrefixTrie trie = new PrefixTrie();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String word = sc.nextLine();
        trie.insert(word);
        System.out.print("Enter prefix to count: ");
        String query = sc.nextLine();
        int result = trie.countPrefix(query);
        System.out.println("Prefix count: " + result);
    }
}
