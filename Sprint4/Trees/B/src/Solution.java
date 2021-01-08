public class Solution {
    public static final String TRUE = "True";
    public static final String FALSE = "False";
    public static String ifBalanced = TRUE;

    public static boolean treeSolution(Node head){
        depthsOfLeaf(head);
        if (ifBalanced.equals(TRUE)) return true;
        else return false;
    }

    static int depthsOfLeaf(Node node){
        if (ifBalanced.equals(FALSE)) return 0;
        int depth_left = 0;
        if (node.left != null) depth_left = depthsOfLeaf(node.left) + 1;

        int depth_right = 0;
        if (node.right != null) depth_right = depthsOfLeaf(node.right) + 1;

        if (Math.abs(depth_left - depth_right) > 1) ifBalanced = FALSE;

        return maxOfTwo(depth_left, depth_right);
    }

    public static int maxOfTwo(int val1, int val2){
        if (val1 > val2) return val1;
        else return val2;
    }

    public static void main(String[] args) {
        /*Node head = new Node(3);
        Node l1 = new Node(8);
        Node l2 = new Node(14);
        Node l3 = new Node(15);
        Node r1 = new Node(10);
        head.left = l1;
        //head.right = r1;
        l1.left = l2;
        l1.right = l3;
        System.out.println(treeSolution(head));
        //if (ifBalanced.equals(TRUE)) System.out.println("Jopa");*/
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
