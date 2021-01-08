import java.util.Arrays;
import java.util.Scanner;

public class L {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        if (s1.length() == 0) {
            System.out.println(s2);
            return;
        }

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]){
                System.out.println(chars2[i]);
                return;
            }
        }

        System.out.println(chars2[chars1.length]);
    }
}
