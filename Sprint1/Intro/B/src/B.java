import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int k = Integer.parseInt(s2);
        String[] strings = s1.split(" ");
        Integer[] nums = new Integer[strings.length];

        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }

        int[] result = new int[10101];
        for (int i = 0; i < result.length; i++) {
            result[i] = 0;
        }

        for (int i = 0; i < nums.length; i++) {
            result[nums[i]]++;
        }
        int max = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < result.length; j++) {
                if (result[j] > result[max]) max = j;
            }
            System.out.print(max+" ");
            result[max] = 0;
            max = 0;
        }

    }
}
