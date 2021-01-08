public class Solution {
    static int max;

    public static String treeSolution(Node head){
        max = head.value;
        dfs_post_order(head);
        return String.valueOf(max);
    }

    public static void dfs_post_order(Node node){
        if (node.left != null) dfs_post_order(node.left);
        if (node.right != null) dfs_post_order(node.right);
        if(node.value > max) max = node.value;
        return;
    }

    public static void main(String[] args) {
        /*
        Node head = new Node(3);
        Node l1 = new Node(8);
        Node l2 = new Node(14);
        Node l3 = new Node(15);
        Node r1 = new Node(10);
        head.left = l1;
        head.right = r1;
        l1.left = l2;
        l1.right = l3;
        System.out.println(treeSolution(head));*/
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
