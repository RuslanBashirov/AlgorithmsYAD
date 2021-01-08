public class Solution {
    public static void main(String[] args) {
       
    }
    public static Node<String> solution(Node<String> head, int idx){
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
        return init;
    }
}