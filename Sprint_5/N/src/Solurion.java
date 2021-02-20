import java.util.Scanner;

public class Solurion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int len = s.length();
        int result = 0;

        int[] counts = new int[58];

        for (int i = 0; i < len; i++) {
            counts[s.charAt(i) - 65]++;
        }

        for (int i = 0; i < counts.length; i++) {
            result += counts[i] / 2;
        }

        result *= 2;

        if (result < len){
            result++;
        }

        System.out.println(result);
    }
}
