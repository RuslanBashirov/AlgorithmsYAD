public class Solution {
    public static boolean ifSearchTree = true;

    public static boolean treeSolution(Node head){
        getMaxInSubTree(head);
        return ifSearchTree;
    }

    public static void getMaxInSubTree(Node node){
        if (!ifSearchTree) return;
        if (node == null) return;

        getMaxInSubTree(node.left);

        if (node.left != null){
            if (node.value <= node.left.value) {ifSearchTree = false; return;}
        }

        getMaxInSubTree(node.right);

        if (node.right != null){
            if (node.value >= node.right.value) ifSearchTree = false;
            else node.value = node.right.value;
        }

    }

    public static void main(String[] args) {
       /* Node head = new Node(5);
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
