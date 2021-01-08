import java.util.Scanner;

public class K {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = Integer.parseInt(sc.nextLine());
        String[] strings = sc.nextLine().split(" ");
        int[] nums = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(strings[i]);
        
        int pieces = 0, max = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] > max) max = nums[i];
            if (max == i) pieces++;
        }

        System.out.println(pieces);
    }
}
