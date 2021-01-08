import java.util.Arrays;
import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        int n = Integer.parseInt(s1);
        String s2 = sc.nextLine();

        if (n == 0) return;
        String[] strings = s2.split(" ");
        int[] nums = new int[strings.length];

        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i+1] == nums[i]){
                System.out.println(nums[i]);
                return;
            }
        }

        System.out.println(nums[nums.length-1]);
    }
}
