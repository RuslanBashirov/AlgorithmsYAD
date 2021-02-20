//46232120
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        StringBuilder[] unpackedStrings = new StringBuilder[n];
        int shortest_length = 100000;
        
        for (int i = 0; i < n; i++) {
            unpackedStrings[i] = unpackString(sc.nextLine());
            if (unpackedStrings[i].length() < shortest_length)
                shortest_length = unpackedStrings[i].length();
        }

        StringBuilder result = new StringBuilder();
        boolean willAddCurrCh = true;

        for (int i = 0; i < shortest_length; i++) {
            char curr_ch = unpackedStrings[0].charAt(i);

            for (int j = 1; j < n; j++) {
                if (unpackedStrings[j].charAt(i) != curr_ch) {
                    willAddCurrCh = false;
                    break;
                }
            }

            if (!willAddCurrCh) break;
            else result.append(curr_ch);
            willAddCurrCh = true;
        }

        System.out.println(result);
    }



    public static boolean isNum(char ch){
        if (ch - 48 <= 9) return true;
        else return false;
    }

    public static StringBuilder unpackString(String str){
        MyStack stack = new MyStack();

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);

            if (isNum(curr)) stack.push(new StringBuilder(String.valueOf(curr)));
            else if ((curr - 97 >= 0) && (curr - 97 < 26)) stack.push(new StringBuilder(String.valueOf(curr)));
            else if (curr == '[') stack.push(new StringBuilder(String.valueOf(curr)));
            else if (curr == ']'){
                StringBuilder res = new StringBuilder();

                while (!stack.isEmpty() && !stack.peek().toString().equals("[")) {
                    res = stack.pop().append(res);
                }

                stack.pop();

                StringBuilder num_from_stack_sb = new StringBuilder();

                while (!stack.isEmpty() &&  isNum(stack.peek().charAt(0))) {
                    num_from_stack_sb.append(stack.pop());
                }

                num_from_stack_sb.reverse();
                int num_from_stack = Integer.parseInt(num_from_stack_sb.toString());
                StringBuilder temp = new StringBuilder(res).reverse();
                res = new StringBuilder();

                for (int j = 0; j < num_from_stack; j++) {
                    res.append(temp);
                }

                stack.push(res.reverse());

            }
            else {
                System.out.println("wrong symbol");
                return null;
            }
        }

        return stack.popAllStack();
    }
}

class MyStack{
    private StringBuilder[] container = new StringBuilder[10];
    private int size = 0;

    public void push(StringBuilder str){
        if (size == container.length){
            StringBuilder[] newContainer = new StringBuilder[container.length * 10];
            for (int i = 0; i < container.length; i++)
                newContainer[i] = container[i];
            
            container = newContainer;
        }
        
        container[size] = str;
        size++;
    }

    public StringBuilder pop(){
        if (size == 0) {
            System.out.println("stack is empty");
            return null;
        }
        
        size--;
        return container[size];
    }

    public StringBuilder peek(){
        if (size == 0) {
            System.out.println("stack is empty");
            return null;
        }
        
        return container[size-1];
    }
    
    public boolean isEmpty(){
        if (size == 0) return true;
        else return false;
    }

    public StringBuilder popAllStack(){
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < size; i++) {
            result.append(container[i]);
        }

        return result;
    }
}

