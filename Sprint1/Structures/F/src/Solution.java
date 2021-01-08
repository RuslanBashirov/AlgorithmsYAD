public class Solution {
    public static void main(String[] args) {
        Node<String> head = new Node<String>("lol",null);
        solution(head, 1);
    }
    public static Node<String> solution(Node<String> head, int idx){
        Node node3 = new Node("kek3", null);
        Node node2 = new Node("kek2", node3);
        Node node1 = new Node("kek1", node2);
        head = node1;
        idx = 0;

        if (head == null) return null;
        if (idx == 0) return head.next;
        Node<String> init = head;
        Node<String> prev = null;
        while (idx >= 1){
            prev = head;
            if (head.next == null) return init;
            head = head.next;
            idx--;
        }
        prev.next = head.next;
        Node<String> out = init;
        while (out != null){
            System.out.println(out.value);
            out = out.next;
        }
        return init;
    }
}
class Node<V> {
    public V value;
    public Node<V> next;

    public Node(V value, Node<V> next) {
        this.value = value;
        this.next = next;
    }
}