import java.util.Scanner;

public class I {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int n = Integer.parseInt(sc.nextLine());

        if (n == 0) return;

        final String[] strings = sc.nextLine().split(" ");
        final int[] nums = new int[n];
        int[] numOfIncls = new int[3];

        for (int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(strings[i]);

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) numOfIncls[0]++;
            else if (nums[i] == 1) numOfIncls[1]++;
            else if (nums[i] == 2) numOfIncls[2]++;
        }

        for (int i = 0; i < numOfIncls.length; i++) {
            for (int j = 0; j < numOfIncls[i]; j++)
                System.out.print(i + " ");
        }
    }

}
