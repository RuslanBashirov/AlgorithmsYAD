import java.util.Scanner;

public class I {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        if (s1.length() > s2.length()) s2 = lengthAlignment(s1, s2);
        else if (s2.length() > s1.length()) s1 = lengthAlignment(s2, s1);

        StringBuilder sb = new StringBuilder();
        char tmp = '0';
        char preSum = '0';
        char postSum = '0';

        for (int i = s1.length() - 1; i >= 0 ; i--) {
            preSum = sum(s1.charAt(i), tmp);
            if (preSum == '2'){
                tmp = '1';
                preSum = '0';
            }
            else tmp = '0';

            postSum = sum(preSum, s2.charAt(i));
            if (postSum == '2'){
                tmp = '1';
                postSum = '0';
            }
            sb.append(postSum);
        }

        if (tmp == '1') sb.append(tmp);

        System.out.println(sb.reverse().toString());
    }

    public static String lengthAlignment(String s1, String s2){ // s1 length must be > s2 length
        int diffLength = s1.length() - s2.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < diffLength; i++) {
            stringBuilder.append("0");
        }
        return stringBuilder.toString().concat(s2);
    }

    public static char sum(char s1, char s2){
        if (s1 == '0' && s2 == '0') {
            return '0';
        }
        else if (s1 == '0' && s2 == '1') {
            return '1';
        }
        else if (s1 == '1' && s2 == '0') {
            return '1';
        }
        else if (s1 == '1' && s2 == '1') {
            return '2';
        }
        else {
            System.out.println("Error in sum args");
            return '9';
        }
    }

}
