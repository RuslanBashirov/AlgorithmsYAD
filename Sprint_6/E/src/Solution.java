import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static ArrayList<String> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Node head = new Node("");


        fulfillTree(head, sc, new ArrayList<>(), n);
        myConcat(head, "");

        //Arrays.sort(result);

        for(String s: result){
            System.out.println(s);
        }



    }

    public static void fulfillTree(Node node, Scanner sc, ArrayList<Node> prevList, int depth){
        if (depth == 0) return;

        int numOfWords = Integer.parseInt(sc.next());

        ArrayList<Node> currArrayList = new ArrayList<>(numOfWords);

        for (int i = 0; i < numOfWords; i++) {
            Node node1 = new Node(sc.next());
            currArrayList.add(node1);
        }
        for (int i = 1; i < prevList.size(); i++) {
            prevList.get(i).alist = currArrayList;
        }
        node.alist = currArrayList;


        fulfillTree(node.alist.get(0), sc, currArrayList, depth-1);

    }

    public static void myConcat(Node node, String sentence){
        node.value = sentence.concat(node.value);

        if (node.alist.size() == 0){
            result.add(node.value);
            return;
        }

        for (int i = 0; i < node.alist.size(); i++) {
            myConcat(node.alist.get(i), node.value);
        }
    }
}

class Node{
    public ArrayList<Node> alist;
    public String value;

    public Node(String value) {
        this.alist = new ArrayList<>();
        this.value = value;
    }
}
