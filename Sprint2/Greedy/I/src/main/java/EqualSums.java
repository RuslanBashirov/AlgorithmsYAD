import java.util.Scanner;

public class EqualSums {
    static private String TRUE = "True";
    static private String FALSE = "False";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 =  sc.nextLine();
        int n = Integer.parseInt(s1);

        if (n == 0 || n == 1){
            System.out.println(FALSE);
            return;
        }

        String[] s2 =  sc.nextLine().split(" ");
        int[] nums = new int[n+1];
        nums[0] = 0;
        int sum = 0;

        for (int i = 1; i < n+1; i++) {
            nums[i] = Integer.parseInt(s2[i-1]);
            sum += nums[i];
        }

        if (sum % 2 != 0){
            System.out.println(FALSE);
            return;
        }

        sum /= 2;
        int rmndr = 0;

        for (int i = n; i > 0; i--) {
            if (sum - nums[i] >= 0){
                rmndr = sum - nums[i];

                for (int j = 0; j <= i - 1; j++) {
                    if (rmndr - nums[j] == 0){
                        System.out.println(TRUE);
                        return;
                    }
                    if (j == i - 1) sum = rmndr;
                }
            }
        }

        System.out.println(FALSE);  //WA for 6
                                    //7 9 3 4 6 7
    }
}
