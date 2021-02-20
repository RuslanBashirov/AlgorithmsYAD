import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String s = reader.readLine();
        reader.close();

        if (s.length() < 10) return;

        Node[] hash = new Node[100000];
        Set<String> resultSet = new HashSet<>();
        int currHash = 0;
        Node currNode;

        for (int i = 0; i < s.length()-9; i++) {
            currHash = getHash(s, i);
            currNode = new Node(s.substring(i, i+10));


            if (hash[currHash] != null) {
                Node temp = hash[currHash];

                while (temp != null){
                    if (temp.val.equals(currNode.getVal())) {
                        resultSet.add(currNode.getVal());
                        break;
                    }

                    if (temp.next == null){
                        currNode.next = hash[currHash];
                        hash[currHash] = currNode;
                    }

                    temp = temp.getNext();
                }
            }
            else hash[currHash] = currNode;


        }

        String[] result = new String[resultSet.size()];

        int i = 0;

        for (String t: resultSet){
            result[i] = t;
            i++;
        }

        Arrays.sort(result);

        for (int j = 0; j < result.length; j++) {
            System.out.println(result[j]);
        }

    }

    public static int getHash(String s, int start){
        int hash = 0;
        int end = start+10;
        int counter = 1;

        for (int i = start; i < end; i++) {
            hash += getValForChar(s.charAt(i)) * counter;
            counter++;
        }

        return hash;
    }

    public static int getValForChar(char ch){
        switch (ch) {
            case 'G':
                return 0;
            case 'O':
                return 1;
            case 'S':
                return 2;
            case 'H':
                return 3;
            case 'A':
                return 4;
            default:
                return -1;
        }
    }


}

class Node{
    Node next;
    String val;

    public Node(String val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public String getVal() {
        return val;
    }

}
