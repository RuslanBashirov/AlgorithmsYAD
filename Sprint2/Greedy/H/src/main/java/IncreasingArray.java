import java.util.Scanner;

public class IncreasingArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int n = Integer.parseInt(s1);
        if (n == 0){
            System.out.println("0");
            return;
        }
        if (n == 1){
            System.out.println(Integer.parseInt(s2));
            return;
        }
        String[] strings = s2.split(" ");
        int[] nums = new int[n];
        int counter = 1;
        int max_counter = 1;
        nums[0] = Integer.parseInt(strings[0]);

        for (int i = 1; i < n; i++) {
            nums[i] = Integer.parseInt(strings[i]);
            if (nums[i] > nums[i-1]) counter++;
            else if (counter > max_counter) {
                max_counter = counter;
                counter = 1;
            }
            else counter = 1;
        }
        max_counter = max_counter > counter ? max_counter : counter;

        System.out.println(max_counter);
    }
}
