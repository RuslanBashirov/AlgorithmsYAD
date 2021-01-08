import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class StackMaxEffective {
    StackOfMaxes stackOfMaxes = new StackOfMaxes();
    LinkedList<Integer> stackEffective = new LinkedList<>();
    public void push(int num){
        stackEffective.addFirst(num);
        stackOfMaxes.push(num);
    }
    public void pop(){
        if (stackEffective.size() == 0) System.out.println("error");
        else {
            stackEffective.remove();
            stackOfMaxes.pop();
        }
    }
    public void get_max(){
        if (stackOfMaxes.getSize() == 0) System.out.println("None");
        else System.out.println(stackOfMaxes.peek());
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        int n = Integer.parseInt(s1);
        String command;

        StackMaxEffective stackMaxEffective = new StackMaxEffective();
        for (int i = 0; i < n; i++) {
            command = sc.nextLine();
            if (command.equals("get_max")) stackMaxEffective.get_max();
            else if (command.equals("pop")) stackMaxEffective.pop();
            else stackMaxEffective.push(Integer.parseInt(command.substring(5)));
        }
    }

    public class StackOfMaxes {
        int[] arr = new int[33333];
        int size = 0;

        public void push(int num) {
            if (size == arr.length) increaseCapacity();
            if (size == 0) arr[size] = num;
            else if (num > arr[size-1]) arr[size] = num;
            else arr[size] = arr[size-1];
            size++;
        }

        public void pop() {
            if (size == 0) System.out.println("error");
            else size--;
        }
        public int peek() {
             return arr[size-1];
        }
        public void increaseCapacity(){
            int[] arr2 = new int[arr.length*3];

            for (int i = 0; i < arr.length; i++)
                arr2[i] = arr[i];

            arr = arr2;
        }
        public int getSize(){
            return size;
        }
    }
}
