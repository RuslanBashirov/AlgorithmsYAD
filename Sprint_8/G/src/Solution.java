import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =  Integer.parseInt(sc.nextLine());
        int[] input = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(sc.next());
        }

        //Arrays.fill(dp, 1);
        ArrayList<Integer>[] list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
            //list[i].add(i);
        }

        int global_max_id = 0;

        for (int i = 0; i < n; i++) {
            int max_id = findMaxId(input, dp, i);
            dp[i] = dp[max_id] + 1;

            list[i].add(i);
            if (max_id != i) list[i].addAll(list[max_id]);

            if (dp[i] > dp[global_max_id]) global_max_id = i;
        }

        System.out.println(dp[global_max_id]);

        ArrayList<Integer>  resultList = list[global_max_id];

        for (int i = resultList.size() - 1; i >= 0; i--) {
            System.out.print((resultList.get(i)+1) + " ");
        }

    }

    public static int findMaxId(int[] nums, int[] dp, int till){
        int max_id = till;

        for (int i = till-1; i >= 0; i--) {
            if (nums[i] < nums[till] && dp[i] > dp[max_id]) {
                max_id = i;
            }
        }

        return max_id;
    }
}
