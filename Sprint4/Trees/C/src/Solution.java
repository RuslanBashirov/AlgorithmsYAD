import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public static List<List<String>> treeSolution(Node head){
        List<List<String>> result = new ArrayList<List<String>>();
        Deque<Node> deque = new ArrayDeque<Node>();
        deque.add(head);
        Node temp;
        int level = 0;

        while (!deque.isEmpty()){
            int level_size = deque.size();
            List<String> list = new ArrayList<>();

            while (level_size > 0) {
                level_size--;
                temp = deque.pop();
                list.add(String.valueOf(temp.value));

                if (temp.left != null) deque.add(temp.left);
                if (temp.right != null) deque.add(temp.right);
            }
            result.add(list);
            level++;
        }

        return result;
    }

    public static void main(String[] args) {
        /*Node head = new Node(3);
        Node l1 = new Node(8);
        Node l2 = new Node(14);
        Node l3 = new Node(15);
        Node r1 = new Node(10);
        head.left = l1;
        head.right = r1;
        l1.left = l2;
        l1.right = l3;
        List<List<String>> res = treeSolution(head);
        for (List<String> arrayList: res) {
            for (int i = 0; i < arrayList.size(); i++) {
                System.out.print(arrayList.get(i)+" ");
            }
            System.out.println();
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
