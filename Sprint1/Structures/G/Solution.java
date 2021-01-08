public class Solution {
    public static void main(String[] args) {
    }
    public static int solution(Node<String> head, String elem){
        int idx = 0;

        while (head != null){
            if (head.value.equals(elem)) return idx;
            head = head.next;
            idx++;
        }
        return -1;
    }
}