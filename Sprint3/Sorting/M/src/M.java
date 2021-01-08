import java.util.Arrays;
import java.util.Scanner;

public class M{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String reference = sc.nextLine();
        int n = Integer.parseInt(sc.nextLine());
        String[] strings = new String[n];

        for (int i = 0; i < n; i++)
            strings[i] = sc.nextLine();

        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; ; ) {
                for (int k = 0; k < reference.length() && j < strings[i].length(); k++) {
                    if (reference.charAt(k) == strings[i].charAt(j))
                        j++;
                }
                if (j < (strings[i].length()) || j > (reference.length() - 1)) {
                    strings[i] = "";
                    break;
                }
                if (strings[i].length() >= maxLength) maxLength = strings[i].length();
                break;
            }
        }

        for (int i = 0; i < n; i++)
            if (strings[i].length() < maxLength) strings[i] = "";

        Arrays.sort(strings);

        for (int i = 0; i < n; i++) {
            if (strings[i] != ""){
                System.out.println(strings[i]);
                break;
            }
        }
    }

}