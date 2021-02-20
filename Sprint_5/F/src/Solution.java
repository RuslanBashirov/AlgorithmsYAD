import java.util.Scanner;

public class Solution {
    public static final String YES = "YES";
    public static final String NO = "NO";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();

        if  (s.length() != t.length()){
            System.out.println(NO);
            return;
        }

        if (!check(s,t) || !check(t,s)) System.out.println(NO);
        else System.out.println(YES);
    }

    public  static boolean check(String s1, String s2){
        char[] hash = new char[26];

        for (int i = 0, index; i < s1.length(); i++) {
            index = s1.charAt(i)-97;

            if (hash[index] == '\u0000')
                hash[index] = s2.charAt(i);
            else if (hash[index] != s2.charAt(i)) return false;
        }

        return true;
    }



}
