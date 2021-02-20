//46228820
import java.util.Scanner;

public class Solution {
    //here i compute prefix function using KMP algoithm
    public static void computeLPSArray(String pat, int M, int lps[]) {
        int len = 0;
        int i = 1;
        lps[0] = 0;

        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else {
                if (len != 0) {
                    len = lps[len - 1];

                }
                else {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = str.length();
        int[] lps = new int[n];

        computeLPSArray(str, n, lps);

        if (n % (n-lps[n-1])  == 0)
            System.out.println(n / (n - lps[n-1]));
        else System.out.println(1);
    }
}
