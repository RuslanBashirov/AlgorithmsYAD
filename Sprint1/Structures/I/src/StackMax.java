import java.util.ArrayList;
import java.util.Scanner;

public class StackMax {
    public int size = 0;
    public ArrayList<Integer> stack = new ArrayList<>();
    public void push(int num){
        stack.add(num);
        size++;
    }
    public void pop(){
        if (size == 0) System.out.println("error");
        else {
            stack.remove(size-1);
            size--;
        }
    }
    public void get_max(){
        if (size == 0) System.out.println("None");
        else {
            int max = stack.get(0), curr;
            for (int i = 0; i < size; i++) {
                curr = stack.get(i);
                if (curr > max) max = curr;
            }
            System.out.println(max);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        int n = Integer.parseInt(s1);
        String command;

        StackMax stackMax = new StackMax();
        for (int i = 0; i < n; i++) {
            command = sc.nextLine();
            if (command.equals("get_max")) stackMax.get_max();
            else if (command.equals("pop")) stackMax.pop();
            else if (command.matches("push (|-)\\d+")) stackMax.push(Integer.parseInt(command.substring(5)));
            else System.out.println("Wrong Command");
        }
    }
}
