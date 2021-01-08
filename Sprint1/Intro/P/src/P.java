import java.util.ArrayList;
import java.util.Scanner;

public class P{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        ArrayList<StringBuilder>[] s1 = new ArrayList<>()[s.length()];
        String[] str_arr = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "fuv", "wxyz"};
        for (int i = 0; i < s.length(); i++) {
            s1[i] = new StringBuilder(str_arr[s.charAt(i)-'0']);
        }

        for (int i = s1.length - 2; i >= 0; i--) {
            for (int j = 0; j < s1[i].length(); j++) {
                for (int k = 0; k < s1[i+1].length(); k++) {
                    s1[i][j] = s1[j].append(s1[i+1][k]);
                }
            }
        }
    }
}
