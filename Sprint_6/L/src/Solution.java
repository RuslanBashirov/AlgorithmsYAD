import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(reader.readLine());

        HashMap<String, Integer> hashMap = new HashMap<>();
        int max = 0;

        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            if (!hashMap.containsKey(input))
                hashMap.put(input, 1);
            else hashMap.put(input, hashMap.get(input)+1);

            if (hashMap.get(input) > max)
                max = hashMap.get(input);
        }

        reader.close();

        String result = "";

        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            Integer value = entry.getValue();

            if (value == max) {
                String key = entry.getKey();

                if ((result.length()>0)) {
                    if (key.compareTo(result) < 0)
                        result = key;
                }
                else result = key;
            }

        }

        System.out.println(result);

    }
}
/*

class TrieNode{
    public HashMap<Character, TrieNode> children = new HashMap<>();
    public String content;
    public int freq;
    public boolean endOfWord;

}

class Trie{
    public TrieNode root;
    public static ArrayList<String> words = new ArrayList<>();
    public int maxFreq = 0;

    Trie(){
        root = new TrieNode();
    }

    public static void retrieveMostFreqWords(TrieNode node){
        if (node.endOfWord) words.addAll(node.content);
        if (node.children.size() == 0) return;

        for (Character key : node.children.keySet())
            retrieveAllWords(node.children.get(key));
    }

    void insert(String word){
        TrieNode current = root;

        for (char l: word.toCharArray()){
            if (!current.children.containsKey(l))
                current.children.put(l, new TrieNode());

            current.children.get(l).freq++;

            current = current.children.get(l);
        }
        //current = current.children.computeIfAbsent(l, c -> new TrieNode());

        current.endOfWord = true;
    }


    boolean find(String word){
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);

            if (node == null) return false;

            current = node;
        }

        return current.endOfWord;
    }


}*/
