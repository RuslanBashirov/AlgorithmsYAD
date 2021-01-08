public class Solution {
    public static int max = 1;

    public static int treeSolution(Node head){
        dfs(head, 1);
        return max;
    }

    static void dfs(Node node, int depth){
        if (node == null) return;
        if (depth > max) max = depth;

        dfs(node.left, depth+1);
        dfs(node.right, depth+1);
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
