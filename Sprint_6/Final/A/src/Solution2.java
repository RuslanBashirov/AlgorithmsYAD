import java.io.*;

public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        //Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(reader.readLine());
        String[] strings = new String[n];
        Trie trie = new Trie();

        for (int i = 0; i < n; i++) {
            strings[i] = reader.readLine();
            trie.insert(strings[i]);
        }

        reader.close();
        //BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
            }
        }

        //writer.close();
    }
}

class Trie{
    final public TrieNode root = new TrieNode();

    public void insert(String str){
        TrieNode temp = root;
        int index;

        for (int i = 0; i < str.length(); i++) {
            index = str.charAt(i) - 'a';

            if (temp.children[index] == null)
                temp.children[index] = new TrieNode();

            temp = temp.children[index];
        }

        temp.isEndOfWord = true;
    }

    public boolean search(String str){
        TrieNode temp = root;
        int index;

        for (int i = 0; i < str.length(); i++) {
            index = str.charAt(i) - 'a';

            if (temp.children[index] == null) return false;

            temp = temp.children[index];
        }

        if (temp != null && temp.isEndOfWord) return true;
        else return false;
    }
}

class TrieNode{
    private static final int ALPHABET_CAPACITY = 26;
    final TrieNode[] children = new TrieNode[ALPHABET_CAPACITY];

    boolean isEndOfWord = false;
}
