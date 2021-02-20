import java.util.HashMap;
import java.util.Scanner;

public class J {
    private static final String YES = "YES";
    private static final String NO = "NO";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String crib = sc.nextLine();
        int n = Integer.parseInt(sc.nextLine());
        Trie trie = new Trie();

        for (int i = 0; i < n; i++) {
            trie.insert(sc.next());
        }

        if (trie.checkIfCrib(crib)) System.out.println(YES);
        else System.out.println(NO);
    }
}

class TrieNode{
    public HashMap<Character, TrieNode> children = new HashMap<>();
    public String content;
    public boolean endOfWord;
}

class Trie{
    private static final String YES = "YES";
    private static final String NO = "NO";
    public TrieNode root;

    Trie(){
        root = new TrieNode();
    }

    void insert(String word){
        TrieNode current = root;

        for (char l: word.toCharArray())
            current = current.children.computeIfAbsent(l, c -> new TrieNode());

        current.endOfWord = true;
    }

    boolean checkIfCrib(String crib){
        TrieNode current = root;

        for (int i = 0; i < crib.length(); i++) {
            char ch = crib.charAt(i);
            TrieNode node = current.children.get(ch);

            if (node == null){
                return false;
            }

            if (node.endOfWord) current = root;
            else current = node;
        }

        return (current == root);
    }

    /*boolean find(String word){
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);

            if (node == null) return false;

            current = node;
        }

        return current.endOfWord;
    }*/


}
