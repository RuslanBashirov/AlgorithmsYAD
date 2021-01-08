import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int n = Integer.parseInt(sc.nextLine());
        final String[] strings = sc.nextLine().split(" ");
        int[] nums = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(strings[i]);

        boolean hadExchange = false;

        for (int i = 0, temp; i < n - 1; i++) {
            hadExchange = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    hadExchange = true;
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }

            if (!hadExchange) break;
        }

        for (int i = 0; i < n; i++)
            System.out.print(nums[i] + " ");
    }

}
