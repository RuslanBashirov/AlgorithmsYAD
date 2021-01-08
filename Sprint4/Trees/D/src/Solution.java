public class Solution {
    static private final String TRUE = "True";
    static private final String FALSE = "False";
    static private String ifAnagram = TRUE;

    public static String treeSolution(Node head){
        checkForAnagram(head, head);
        return ifAnagram;
    }

    static void checkForAnagram(Node node1, Node node2){
        if (node1.value != node2.value){
            ifAnagram = FALSE;
            return;
        }

        if ((node1.left != null) && (node2.right != null)) checkForAnagram(node1.left, node2.right);
        else if ((node1.left != null) || (node2.right != null)){
            ifAnagram = FALSE;
            return;
        }

        if ((node1.right != null) && (node2.left != null)) checkForAnagram(node1.right, node2.left);
        else if ((node1.right != null) || (node2.left != null)){
            ifAnagram = FALSE;
            return;
        }
    }

    public static void main(String[] args) {
        /*Node head = new Node(3);
        Node l1 = new Node(8);
        Node l2 = new Node(14);
        Node l3 = new Node(14);
        Node r1 = new Node(8);
        head.left = l1;
        head.right = r1;
        r1.left = l2;
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
