import java.util.LinkedList;
import java.util.Scanner;


public class P{
    int MAX_LENGTH = 1000;
    int size = 0;
    LinkedList<Integer> queue = new LinkedList<>();

    void put(int num){
        queue.add(num);
        size++;
    }
    void get(){
        if (size == 0){
            System.out.println("error");
            return;
        }
        else {
            System.out.println(queue.getFirst());
            queue.removeFirst();
            size--;
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
        String command;
        P queue = new P();
        for (int i = 0; i < n; i++) {
            command = sc.nextLine();
                if (command.charAt(0) == 'p'){
                    queue.put(Integer.parseInt(command.substring(4)));
                }
                else if (command.charAt(0) == 'g'){
                    queue.get();
                }
                else{
                    System.out.println(queue.size());
                }
        }
    }
}
