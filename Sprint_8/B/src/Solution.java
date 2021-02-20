import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = Integer.parseInt(sc.nextLine());
        int k = Integer.parseInt(sc.nextLine());

        int[] dp = new int[x+1];

        int[] coins = new int[k];
        dp[0] = 0;

        for (int i = 0; i < k; i++) {
            coins[i] = Integer.parseInt(sc.next());
        }

        int result = getMin(dp, coins, k, x);

        if (result <= x) System.out.println(result);
        else System.out.println(-1);

    }

    public static int getMin(int[] dp, int[] coins, int k, int x){
        if (x < 0) return Integer.MAX_VALUE - 10000;
        if (x == 0) return 0;
        if (dp[x] != 0) return dp[x];

        int curr_min = Integer.MAX_VALUE - 10000;

        for (int j = 0; j < k; j++) {
            curr_min = Math.min(getMin(dp, coins,k, x - coins[j]) + 1, curr_min);
        }

        dp[x] = curr_min;

        return curr_min;
    }
}
