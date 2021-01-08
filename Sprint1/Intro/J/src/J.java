import java.util.Arrays;
import java.util.Scanner;

public class J {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int n = Integer.parseInt(s1);
        String[] strings = s2.split(" ");
        int[] nums = new int[n];

        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }

        Arrays.sort(nums);

        for (int i = 0; i < n-1; i+=2) {
            if (nums[i+1] != nums[i]){
                System.out.println(nums[i]);
                return;
            }

        }

        System.out.println(nums[n-1]);
    }
}
