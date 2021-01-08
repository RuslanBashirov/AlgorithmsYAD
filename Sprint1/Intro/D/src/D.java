import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        int n = Integer.parseInt(s1);
        String s2 = sc.nextLine();
        s2 = s2.replaceAll(" 0", "");
        if (s2.charAt(0) == '0') {
            if (n == 1) return;
            s2 = s2.substring(2);
        }

        System.out.println(s2);
    }
}
