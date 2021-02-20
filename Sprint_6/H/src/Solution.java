import java.util.Scanner;

public class Solution {
    private static final String YES = "YES";
    private static final String NO = "NO";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        if (s.length() % 2 != 0){
            System.out.println(NO);
            return;
        }

        int openBrackets = 0;
        int closeBrackets = 0;
        int additional = 0;
        //int otherSymbols = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') openBrackets++;
            else if (s.charAt(i) == ')') closeBrackets++;
            else {
                System.out.println("wrong symbol");
                return;
            }

            if (closeBrackets > openBrackets){
                additional++;
                closeBrackets--;
                openBrackets++;
            }
        }

        System.out.println(YES);
        System.out.println((openBrackets-closeBrackets)/2 + additional);
    }
}
