public class Solution {
    public static void main(String[] args) {
    }
    public static Node<String> solution(Node<String> head){
        Node temp = null;
        while (head != null) {
            temp = head.next;
            head.next = head.prev;
            head.prev = temp;
            if (temp == null) return head;
            head = temp;
        }
        return temp;
    }
}
