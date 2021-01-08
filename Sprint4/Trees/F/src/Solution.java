import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public static List<String> treeSolution(Node head){
        List<String> allLeftSeen = new ArrayList<>();
        bfs(head, allLeftSeen);
        return allLeftSeen;
    }

    public static void bfs(Node node, List<String> allLeftSeen){
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(node);
        int level = 0;
        Node temp;

        while (!deque.isEmpty()){
            int level_size = deque.size();
            int currSeenVal = deque.peek().value;
            allLeftSeen.add(String.valueOf(currSeenVal));

            //System.out.print(level+": ");

            while (level_size > 0){
                level_size--;
                temp = deque.pop();
                //System.out.print(temp.value+" ");

                if (temp.left != null) deque.add(temp.left);
                if (temp.right != null) deque.add(temp.right);
            }
            level++;
            //System.out.println();
        }
    }

    public static void main(String[] args) {
        /*Node head = new Node(3);
        Node l1 = new Node(8);
        Node l2 = new Node(14);
        Node l3 = new Node(15);
        Node l3r = new Node(9);
        Node r1 = new Node(10);
        head.left = l1;
        head.right = r1;
        l1.left = l2;
        l1.right = l3;
        l1.right.right = l3r;
        for (String res:
                treeSolution(head)) {
            System.out.println(res);
        }*/
    }
}

/*class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }
}*/
