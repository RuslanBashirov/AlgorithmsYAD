import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);//84952152559
        final int n = Integer.parseInt(sc.nextLine());
        final String[] strings = sc.nextLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(strings[i]);

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] > nums[i]){
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    i--;
                }
                else break;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(nums[i]+" ");
        }

    }

}
