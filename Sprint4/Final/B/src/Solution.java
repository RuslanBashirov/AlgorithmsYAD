//42798638
public class Solution {
    static int global_max;

    public static int treeSolution(Node head){
        global_max = head.value;
        dfs(head);
        return global_max;
    }

    public static int dfs(Node node){
        if (node == null) return 0;

        int val1 = dfs(node.left) + node.value;
        int val2 = dfs(node.right) + node.value;
        int val3 = node.value;
        int val4 = val1 + val2 - val3;
        int maxOf4 = maxOfN(val1, val2, val3, val4);

        if (maxOf4 > global_max) global_max = maxOf4;

        if (maxOf4 == val4) return maxOfN(val1, val2, val3); //i. e. return maxOf3
        else return maxOf4;
    }

    public static int maxOfN(int... values){
        for (int i = 1; i < values.length; i++)
            values[0] = Math.max(values[0], values[i]);

        return values[0];
    }

    public static void main(String[] args) {
        /*Node head = new Node(-1);
        head.left = new Node(2);
        head.right = new Node(-3);
        head.left.left = new Node(7);
        head.left.right = new Node(3);
        head.left.left.left = new Node(-1);
        head.left.right.left = new Node(9);
        head.left.right.right = new Node(-6);
        head.right.left = new Node(5);
        head.right.right = new Node(1);
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
