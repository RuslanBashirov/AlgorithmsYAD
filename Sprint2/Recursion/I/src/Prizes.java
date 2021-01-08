import java.util.Scanner;

public class Prizes {
    static final String TRUE = "True";
    static final String FALSE = "False";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = Integer.parseInt(sc.nextLine());
        int n  = Integer.parseInt(sc.nextLine());
        String[] strings = sc.nextLine().split(" ");
        int[] winners = new int[k];
        int[] coins = new int[n];

        for (int i = 0; i < n; i++)
            coins[i] = Integer.parseInt(strings[i]);


        if (eqPrizes(coins,0, 0, 0, n)){
            System.out.println(TRUE);
            return;
        }
        else System.out.println(FALSE);
    }

    static boolean eqPrizes(int[] coins, int sum1, int sum2, int pos, int n) {
        if (pos == n) {
            if (sum1 == sum2) {
                return true;
            }
            else return false;
        }
        else {
            if (eqPrizes(coins, sum1 + coins[pos], sum2, pos + 1, n)) return true;
            if (eqPrizes(coins, sum1, sum2 + coins[pos], pos + 1, n)) return true;
            return false;
        }
    }
}
