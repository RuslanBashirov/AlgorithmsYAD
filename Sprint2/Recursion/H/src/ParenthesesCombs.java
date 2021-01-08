import java.util.Scanner;

public class ParenthesesCombs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        if (n == 0) return;
        char[] arr = new char[2*n];
        printParentheses(arr, 0, n, 0, 0);
    }

    static void printParentheses(char[] arr, int pos, int n, int open, int close){
        if (close == n){
            for (int i = 0; i < 2*n; i++)
                System.out.print(arr[i]);
            System.out.println();
        }
        else {
            if (open < n){
                arr[pos] = '(';
                printParentheses(arr, pos+1, n, open+1, close);
            }
            if (open > close){
                arr[pos] = ')';
                printParentheses(arr, pos+1, n, open, close+1);
            }
        }
    }
}
