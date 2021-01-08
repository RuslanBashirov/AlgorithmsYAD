public class Solution {
    public static void main(String[] args) {

    }
    public static void solution(Node<String> head){
        if (head == null) return;
        while (head.next != null){
            System.out.println(head.value);
            head = head.next;
        }
        System.out.println(head.value);
    }
}
/*class Node<V> {
    public V value;
    public Node<V> next;

    public Node(V value, Node<V> next) {
        this.value = value;
        this.next = next;
    }
}*/
