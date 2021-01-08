import java.util.Scanner;

public class H {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        StringBuilder s2 = new StringBuilder();
        s1 = s1.replaceAll("[^a-zA-Z]","");
        s1 = s1.toLowerCase();

        for (int i = s1.length() - 1; i >= 0; i--) {
            s2 = s2.append(s1.charAt(i));
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)){
                System.out.println("False");
                return;
            }
        }

        System.out.println("True");
    }
}
