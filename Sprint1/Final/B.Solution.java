public class Solution {
    static String FALSE = "False";
    static String TRUE = "True";
    public static String hasCycle (Node head){
        Node temp1 = head;
        Node temp2 = head;
        while (temp2.hasNext()){
            temp1 = temp1.getNext();
            temp2 = temp2.getNext();

            if (temp2.hasNext()) temp2 = temp2.getNext();
            else return FALSE;

            if (temp1 == temp2) return TRUE;
        }
        return FALSE;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node3);
        node4.setNext(node2);
        System.out.println(hasCycle(node1));
    }
}
