import java.util.Scanner;

public class Calculator {
    static String PLUS = "+";
    static String MINUS = "-";
    static String MULTIPLICATION = "*";
    static String DIVISION = "/";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input_line = sc.nextLine();
        if (input_line.length() == 0) return;

        String[] input_arr = input_line.split(" ");
        MyStack stack = new MyStack(input_arr.length);
        int num1, num2, res;

        for (int i = 0; i < input_arr.length; i++) {
            if (input_arr[i].equals(PLUS) || input_arr[i].equals(MINUS)
                || input_arr[i].equals(MULTIPLICATION) || input_arr[i].equals(DIVISION)){
                pushResultToStack(input_arr[i], stack);
            }
            else stack.push(Integer.parseInt(input_arr[i]));
        }

        System.out.println(stack.pop());
    }

    public static void pushResultToStack(String sign, MyStack stack){
        int num2 = stack.pop();
        int num1 = stack.pop();
        int resultOfOperation = 0;
        switch (sign){
            case "+": resultOfOperation = num1 + num2; break;
            case "-": resultOfOperation = num1 - num2; break;
            case "*": resultOfOperation = num1 * num2; break;
            case "/": resultOfOperation = num1 / num2; break;
        }
        stack.push(resultOfOperation);
    }
}

class MyStack {
    int size = 0;
    int[] stack;

    MyStack(int max_length){
        stack = new int[max_length];
    }

    void push(int num){
        if (stack.length == size){
            System.out.println("Error stack is full");
            return;
        }
        stack[size] = num;
        size++;
    }

    int pop(){
        if (size == 0){
            System.out.println("Error stack is already empty");
            return Integer.MIN_VALUE;
        }
        size--;
        return stack[size];
    }
}
