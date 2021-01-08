import java.util.Scanner;
import java.util.Stack;

public class BracketSeq {
    public static void is_correct_bracket_seq(String str){
        int size = str.length();
        if (size % 2 != 0) {
            System.out.println("False");
            return;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < size; i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {
                stack.push(str.charAt(i));
            }
            else if (!stack.isEmpty() &&
                    ((stack.peek() == '(' && str.charAt(i) == ')') ||
                    (stack.peek() == '[' && str.charAt(i) == ']') ||
                    (stack.peek() == '{' && str.charAt(i) == '}'))){
                stack.pop();
            }
            else {
                System.out.println("False");
                return;
            }
        }
        System.out.println("True");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        is_correct_bracket_seq(str);
    }
}
