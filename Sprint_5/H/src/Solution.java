import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        if (n == 0){
            System.out.println(0);
            return;
        }

        String[] s1 = sc.nextLine().split(" ");
        int m = Integer.parseInt(sc.nextLine());
        if (m == 0){
            System.out.println(0);
            return;
        }

        String[] s2 = sc.nextLine().split(" ");
        int[] nums = new int[2550000];

        markIndex(nums, s1, n);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= i; j++) {
                StringBuilder temp_sb = new StringBuilder();

                for (int k = j; k <= i; k++) temp_sb.append(s2[k]);

                int curr_id = Integer.parseInt(temp_sb.toString());

                if (nums[curr_id] == -1) nums[curr_id] = i-j+1;
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > 0){
                System.out.println(nums[i]);
                return;
            }
        }

        System.out.println(0);

    }

    public static void markIndex(int[] nums, String[] s, int capac){
        for (int i = 0; i < capac; i++) {
            for (int j = 0; j <= i; j++) {
                StringBuilder temp_sb = new StringBuilder();

                for (int k = j; k <= i; k++) {
                    temp_sb.append(s[k]);
                }
                nums[Integer.parseInt(temp_sb.toString())] = -1;
            }
        }
    }


}
