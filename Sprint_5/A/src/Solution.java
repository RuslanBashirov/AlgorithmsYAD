import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int reminder, result = 0;
        int[] memo = new int[406];


        while (memo[result] != 1) {
            memo[result] = 1;
            result = 0;

            while (n != 0) {
                reminder = n % 10;
                n /= 10;
                result += reminder * reminder;
            }
            if (result == 1) {
                System.out.println("True");
                return;
            }
            n = result;
        }

        System.out.println("False");
    }
}
