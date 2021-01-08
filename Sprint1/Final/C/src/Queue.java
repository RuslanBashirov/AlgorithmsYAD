import java.util.Scanner;

public class Queue {
    int size = 0;
    Node head;
    Node tail;
    MyStack stack;

    Queue(int n){
        head = new Node(0, null);
        tail = head;
        stack = new MyStack(n);
        stack.push(head);
    }

    void put(int val){
        Node curr_node = new Node(val, null);
        stack.peek().setNext(curr_node);
        tail = curr_node;
        stack.push(curr_node);
        size++;
    }

    Node get(){
        if (size == 0) {
            System.out.println("error");
            return null;
        }
        else {
            Node curr_node = new Node(head.next.getValue(), null);
            head = head.next;
            tail = stack.peek();
            size--;
            return curr_node;
        }
    }

    int get_size(){
        return size;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n_str = sc.nextLine();
        if (n_str.length() == 0) return;
        int n = Integer.parseInt(n_str);
        String command;
        char char0;
        Node curr_el;
        Queue queue = new Queue(n);

        for (int i = 0; i < n; i++) {
            command = sc.nextLine();
            char0 = command.charAt(0);
            if (char0 == 'p') queue.put(Integer.parseInt(command.substring(4)));
            else if (command.length() < 4) {
                curr_el = queue.get();
                if (curr_el != null) System.out.println(curr_el.getValue());
            }
            else System.out.println(queue.get_size());
        }
    }
}

class MyStack {
    int size = 0;
    Node[] stack;

    MyStack(int max_length) {
        stack = new Node[max_length];
    }

    void push(Node node) {
        if (stack.length == size) {
            System.out.println("Error stack is full");
            return;
        }
        stack[size] = node;
        size++;
    }

    Node peek() {
        if (size == 0) {
            System.out.println("Error stack is already empty");
            return null;
        }
        return stack[size-1];
    }
}

class Node{
    int value;
    Node next;
    Node (int val, Node node){
        value = val;
        next = node;
    }
    void setValue(int val){
        value = val;
    }
    int getValue(){
        return value;
    }
    void setNext(Node node){
        next = node;
    }
}
