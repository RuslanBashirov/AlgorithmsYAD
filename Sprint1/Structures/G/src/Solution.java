public class Solution {
    public static void main(String[] args) {
        Node<String> head = new Node<String>("lol",null);
        System.out.println(solution(head, "kek"));
    }
    public static int solution(Node<String> head, String elem){
        Node node3 = new Node("kek3", null);
        Node node2 = new Node("kek2", node3);
        Node node1 = new Node("kek1", node2);
        head = node1;
        int idx = 0;

        while (head != null){
            if (head.value.equals(elem)) return idx;
            head = head.next;
            idx++;
        }
        return -1;
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