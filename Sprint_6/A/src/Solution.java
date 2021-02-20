import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        //one two

        int r = str.length(), l = str.length()-1;

        for (; l >= 0 ; l--) {
            String auxiliary;

            if (l == 0){
                auxiliary = str.substring(l, r);
                System.out.print(auxiliary+" ");
            }

            if (str.charAt(l) == ' ') {
                auxiliary = str.substring(l + 1, r);
                System.out.print(auxiliary+" ");
                r = l;
            }

        }
    }
}
