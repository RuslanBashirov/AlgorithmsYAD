public class Solution {
    public static String ifSame = "True";

    public static String treeSolution(Node... heads){
        checkEquality(heads[0], heads[1]);
        return ifSame;
    }

    static void checkEquality(Node head1, Node head2) {
        if (head1.value != head2.value) ifSame = "False";

        if ((head1.left != null) && (head2.left != null)) {
            checkEquality(head1.left, head2.left);
        } else if ((head1.left != null) || (head2.left != null)) {
            ifSame = "False";
            return;
        }

        if ((head1.right != null) && (head2.right != null)) {
            checkEquality(head1.right, head2.right);
        } else if ((head1.right != null) || (head2.right != null)){
            ifSame = "False";
            return;
        }
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

        Node head2 = new Node(3);
        Node l12 = new Node(8);
        Node l22 = new Node(14);
        Node l32 = new Node(15);
        Node r12 = new Node(10);
        head2.left = l12;
        head2.right = r12;
        l12.left = l22;
        l12.right = l32;

        System.out.println(treeSolution(head, head2));*/
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
