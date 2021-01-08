//42682168
import java.util.Scanner;

public class A {
    private static long[] memo = new long[21];

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int n = Integer.parseInt(sc.nextLine());

        System.out.println(sumOfBSTs(n));
    }

    public static long sumOfBSTs(int n){
        long sum = 0l;

        for (int i = 1; i <= n; i++)
            sum += numBST(i-1) * numBST(n-i);

        memo[n] = sum;

        return sum;
    }


    public static long numBST(int n){
        if ((n == 0) || (n == 1)) return 1l;
        if (memo[n] != 0) return memo[n];

        return sumOfBSTs(n);
    }
}
