import java.util.Scanner;

public class Solution {
    private static final String YES = "YES";
    private static final String NO = "NO";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] counts = new int[26];
        int currIndex;

        for (int i = 0; i < s.length(); i++) {
            currIndex = s.charAt(i) - 97;
            counts[currIndex]++;
        }

        for (int i = 0; i < s.length(); i++) {
            currIndex = s.charAt(i) - 97;

            if (counts[currIndex] == 1){
                System.out.println(YES);
                System.out.println(s.charAt(i));
                return;
            }
        }

        System.out.println(NO);
    }
}
