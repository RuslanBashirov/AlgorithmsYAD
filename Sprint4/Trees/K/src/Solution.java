public class Solution {
    public static int result = 0;

    public static int treeSolution(Node head){
        dfs(head, 0);
        return result;
    }

    public static void dfs(Node node, int sum){
        if (node.left == null && node.right == null) result += 10 * sum + node.value;
        if (node.left != null) dfs(node.left, 10*sum + node.value);
        if (node.right != null) dfs(node.right, 10*sum + node.value);
    }

    public static void main(String[] args) {
        /*Node head = new Node(5);
        Node l1 = new Node(3);
        Node l2 = new Node(1);
        Node l3 = new Node(4);
        Node r1 = new Node(8);
        head.left = l1;
        head.right = r1;
        l1.left = l2;
        l1.right = l3;
        System.out.println(treeSolution(head));*/
    }
}

/*

class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }
}*/
