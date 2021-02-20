import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    private static final ArrayList<StringBuilder> result = new ArrayList<>();
    private static int RANK;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RANK = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= 9; i++) {
            calc(i, 0, new StringBuilder());
        }


        for (StringBuilder sb: result)
            System.out.println(sb);
    }

    public static void calc(int n, int sum, StringBuilder sb){
        if (sb.length()%2 != 0) sum+=n;
        else sum-=n;

        sb.append(n);

        if (sb.length()==RANK && sum==0) result.add(sb);

        if (sb.length() >= RANK) return;

        if (sb.length() == RANK-1){
            calc(Math.abs(sum), sum, new StringBuilder(sb));
        }
        else {
            for (int i = 0; i <= 9; i++) {
                calc(i, sum, new StringBuilder(sb));
            }
        }


    }
}
