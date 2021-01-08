import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        int n = Integer.parseInt(s1);
        String s2 = sc.nextLine();
        int m = Integer.parseInt(s2);
        int[][] array = new int[n+2][m+2];

        for (int i = 0; i < m + 2; i++) {
            array[0][i] = 1001;
            array[n+1][i] = 1001;
        }


        for (int i = 1; i < n + 1; i++) {
            int[] nums = new int[m+2];
            array[i] = parseToNums(sc, nums, m);
        }

        int tag_i = Integer.parseInt(sc.nextLine()) + 1;
        int tag_j = Integer.parseInt(sc.nextLine()) + 1;
        int[] result = {array[tag_i+1][tag_j], array[tag_i-1][tag_j],
                array[tag_i][tag_j+1], array[tag_i][tag_j-1]};
        Arrays.sort(result);
        for (int i = 0; i < result.length; i++) {
            if (result[i] != 1001) System.out.print(result[i]+" ");
        }

    }

    public static int[] parseToNums(Scanner sc, int[] nums, int m){
        String[] strings = sc.nextLine().split(" ");
        nums[0] = 1001;
        for (int k = 1; k < m + 1; k++) {
            nums[k] = Integer.parseInt(strings[k-1]);
        }
        nums[m+1] = 1001;
        return nums;
    }
}
