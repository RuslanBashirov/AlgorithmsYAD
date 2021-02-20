import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int k = Integer.parseInt(sc.next());
        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int sum = 0;
            int copy_of_k = k;

            for (int j = i - 1; (j >= 0) && (copy_of_k > 0); j--, copy_of_k--) {
                sum += dp[j];
                sum %= 1000000007;
            }

            dp[i] = sum % 1000000007;
        }

        System.out.println(dp[n]);
    }
}

