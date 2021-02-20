import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = Long.parseLong(sc.nextLine());
        long m = Long.parseLong(sc.nextLine());
        String str = sc.nextLine();
        long hash = 0;
        int length = str.length();

        for (int i = 0; i < length; i++) {
            hash = (hash * a + (long) str.charAt(i)) % m;
        }

        System.out.println(hash);
    }
}
