import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(reader.readLine());
        int[] prices = new int[n];
        int max_coupons = 0;
        int under, above, left, min;

        for (int i = 0; i < n; i++) {
            prices[i] = Integer.parseInt(reader.readLine());
            
            if (prices[i] > 500) max_coupons++;
        }

        int[][] dp = new int[max_coupons+3][n];

        for (int i = 0; i < max_coupons+3; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE/2;
            }
        }

        if (prices[0] > 500) dp[2][0] = prices[0];
        else dp[1][0] = prices[0];
        

        for (int j = 1; j < n; j++) {

            for (int i = 1; i < max_coupons + 2; i++) {
                under = dp[i+1][j-1];

                if (prices[j] > 500) {
                    left = Integer.MAX_VALUE/2;
                    above = dp[i-1][j-1] + prices[j];
                }
                else {
                    left = dp[i][j-1] + prices[j];
                    above = Integer.MAX_VALUE/2;
                }

                min = minOf3Nums(above, under, left);

                if (min > 1000000) continue;

                if (above == min) dp[i][j] = above;
                else if (under == min) {
                    dp[i][j] = under;
                }
                else dp[i][j] = left;
            }

        }

        int min_sum = Integer.MAX_VALUE;
        int min_sum_i = 0;

        for (int i = 0; i < max_coupons+3; i++) {
            if (dp[i][n-1] < min_sum){
                min_sum = dp[i][n-1];
                min_sum_i = i;
            }
        }

        ArrayList<Integer> daysOfCoupons = new ArrayList<>();

        for (int j = n-1; j > 0; j--) {
            above = dp[min_sum_i-1][j-1];
            left = dp[min_sum_i][j-1];
            under = dp[min_sum_i+1][j-1];
            int curr = dp[min_sum_i][j];

            if (curr == under){
                min_sum_i = min_sum_i + 1;
                daysOfCoupons.add(j+1);
            }
            else if (above < left) min_sum_i = min_sum_i - 1;
        }

        System.out.println(min_sum + " " + daysOfCoupons.size());

        for (int i = daysOfCoupons.size()-1; i >= 0; i--) {
            System.out.print(daysOfCoupons.get(i) + " ");
        }

    }

    public static int minOf3Nums(int n1, int n2, int n3){
        if (n1 < n2) return Math.min(n1, n3);
        else return Math.min(n2, n3);
    }
}
