import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class StackSet {
    HashSet<Integer> stackSet = new HashSet<>();
    ArrayList<Integer> stackList = new ArrayList<>();
    void push(int num){
        if (stackSet.add(num)) stackList.add(num);
    }
    int size(){
        return stackSet.size();
    }
    void peek(){
        if (size() == 0) System.out.println("error");
        else System.out.println(stackList.get(stackList.size()-1));
    }
    void pop(){
        if (size() == 0) System.out.println("error");
        else {
            stackSet.remove(stackList.get(stackList.size()-1));
            stackList.remove(stackList.get(stackList.size()-1));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        char char0, char1;
        StackSet stackSet = new StackSet();
        for (int i = 0; i < n; i++) {
            String command = sc.nextLine();
            char0 = command.charAt(0);
            char1 = command.charAt(1);
            if (char0 == 'p') {
                if (char1 == 'u') stackSet.push(Integer.parseInt(command.substring(5)));
                else if (char1 == 'o') stackSet.pop();
                else if (char1 == 'e') stackSet.peek();
            }
            else System.out.println(stackSet.size());
        }
    }
}
