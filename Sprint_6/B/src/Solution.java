import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private static final String OK = "OK";
    private static final String FAIL = "FAIL";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        if (Math.abs(s1.length() - s2.length()) > 1) {
            System.out.println(FAIL);
            return;
        }

        String longer = s1.length() >= s2.length() ? s1 : s2;
        String shorter = s1.length() < s2.length() ? s1 : s2;

        int diffCounter = 0;

        for (int l = 0, s = 0; l < longer.length()
                && s < shorter.length(); l++, s++) {
            if (longer.charAt(l) != shorter.charAt(s)){
                if (longer.length() != shorter.length()){
                    l++;
                }
                diffCounter++;
            }

            if (diffCounter > 1) {
                System.out.println(FAIL);
                return;
            }
        }

        System.out.println(OK);
    }
}
