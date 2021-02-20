import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        if (s.length() == 0){
            System.out.println();
            return;
        }

        char[] chars = s.toCharArray();

        Arrays.sort(chars);

        StringBuilder sb = new StringBuilder();
        char midChar = '\0';

        for (int i = 0; i < chars.length; i++) {
            if ((i+1 < chars.length) && chars[i+1] == chars[i]) {
                sb.append(chars[i]);
                i++;
            }
            else if (midChar == '\0'){
                midChar = chars[i];
            }
        }

        if (sb.length() == 0) {
            System.out.println(chars[0]);
            return;
        }

        StringBuilder sb2 = new StringBuilder(sb);
        sb2.reverse();
        if (midChar != '\0') sb.append(midChar);

        System.out.println(sb.append(sb2));


    }
}
