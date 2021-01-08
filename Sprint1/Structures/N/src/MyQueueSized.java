import java.util.Scanner;

public class MyQueueSized {
    int MAX_LENGTH;
    int[] queue;
    MyQueueSized(int max_size){
        MAX_LENGTH = max_size;
        queue = new int[MAX_LENGTH];
    }
    int head = 0, tail = 0, size = 0;
    void push(int num){
        if (size == MAX_LENGTH){
            System.out.println("error");
            return;
        }
        queue[tail] = num;
        tail = (tail+1) % MAX_LENGTH;
        size++;
    }
    void pop(){
        if (size == 0){
            System.out.println("None");
            return;
        }
        else {
            System.out.println(queue[head]);
            queue[head] = Integer.MIN_VALUE;
            head = (head+1) % MAX_LENGTH;
            size--;
        }
    }
    void peek(){
        if (size == 0){
            System.out.println("None");
            return;
        }
        else {
            System.out.println(queue[head]);
        }
    }
    int size(){
        return size;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        if (s1 == "") return;
        int n = Integer.parseInt(s1);
        int size = Integer.parseInt(sc.nextLine());
        String command = new String();
        MyQueueSized queue = new MyQueueSized(size);
        for (int i = 0; i < n; i++) {
            command = sc.nextLine();
            if (command.charAt(0) == 'p'){
                if (command.charAt(1) == 'u'){
                    queue.push(Integer.parseInt(command.substring(5)));
                }
                else if (command.charAt(1) == 'o'){
                    queue.pop();
                }
                else if (command.charAt(1) == 'e'){
                    queue.peek();
                }
            }
            else System.out.println(queue.size);
        }
    }
}
