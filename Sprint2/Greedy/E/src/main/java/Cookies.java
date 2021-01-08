import java.util.Arrays;
import java.util.Scanner;

public class Cookies {
    public static void main(String[] args) {
        /*ByteArrayInputStream bais = new ByteArrayInputStream(args[0].getBytes());
        System.setIn(bais);*/
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String s3 = sc.nextLine();
        String s4 = sc.nextLine();
        int n = Integer.parseInt(s1);
        int m = Integer.parseInt(s3);
        String[] s2_strings = s2.split(" ");
        String[] s4_strings = s4.split(" ");
        int[] children = new int[n];
        int[] cookies = new int[m];

        for (int i = 0; i < n; i++)  children[i] = Integer.parseInt(s2_strings[i]);
        for (int i = 0; i < m; i++) cookies[i] = Integer.parseInt(s4_strings[i]);

        Arrays.sort(children);
        Arrays.sort(cookies);
        int result = 0;

        for (int i = 0, j = 0; j < cookies.length && i < children.length; j++) {
            if (cookies[j] >= children[i]) {
                i++;
                result++;
            }
        }

        System.out.println(result);
    }
}
