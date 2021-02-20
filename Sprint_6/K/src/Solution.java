import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static ArrayList<String> result = new ArrayList<>();
    public static int numOfResults = 0;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] strings = new String[n];

        for (int i = 0; i < n; i++) strings[i] = sc.nextLine();

        Trie trie = new Trie();

        for (String s: strings)
            trie.insert(s);

        int m = Integer.parseInt(sc.nextLine());

        if (m == 0){
            retrieveAllWords(trie.root);
            String[]  temp = result.toArray(new String[0]);
            numOfResults += temp.length;

            Arrays.sort(temp);

            for (String p : temp)
                System.out.println(p);

            return;
        }

        for (int i = 0; i < m; i++) {
            TrieNode node = trie.find(sc.nextLine());

            if (node != null) {
                retrieveAllWords(node);

                String[]  temp = result.toArray(new String[0]);
                numOfResults += temp.length;

                Arrays.sort(temp);

                for (String p : temp)
                    System.out.println(p);

                result.clear();
            }
        }
        if (numOfResults == 0) System.out.println();
    }

    public static void retrieveAllWords(TrieNode node){
        if (node.endOfWord) result.addAll(node.content);
        if (node.children.size() == 0) return;

        for (Character key : node.children.keySet())
            retrieveAllWords(node.children.get(key));
    }
}


class TrieNode{
    public HashMap<Character, TrieNode> children = new HashMap<>();
    public ArrayList<String> content = new ArrayList<>();
    public boolean endOfWord;
}


class Trie{
    public TrieNode root;

    Trie(){
        root = new TrieNode();
    }

    void insert(String word){
        TrieNode current = root;
        String acroWord = word.replaceAll("[^A-Z]", "");

        for (char l: acroWord.toCharArray()) {
            if (!current.children.containsKey(l)){
                current.children.put(l, new TrieNode());
                current = current.children.get(l);
            }
            else current = current.children.get(l);
        }
        current.content.add(word);
        current.endOfWord = true;
    }


    TrieNode find(String word){
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);

            if (node == null) return null;

            current = node;
        }

        if (current.endOfWord) return current;
        else return null;
    }
}
