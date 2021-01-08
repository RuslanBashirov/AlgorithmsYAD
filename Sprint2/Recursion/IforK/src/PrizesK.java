import java.util.Scanner;

public class PrizesK{
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


        if (eqPrizes(winners, coins,0, 0, k, n)){
            System.out.println(TRUE);
            return;
        }
        else System.out.println(FALSE);
    }

    static boolean eqPrizes(int[] winners, int[] coins, int sum1, int pos, int k, int n) {
        if (pos == n) {
            for (int i = 1; i < k; i++)
                if (winners[i] != winners[i-1]) return false;
            return true;
        }
        else {
            for (int i = 0; i < k; i++) {
                winners[i] = winners[i] + coins[pos];
                if (eqPrizes(winners, coins, winners[i], pos + 1, k, n)) return true;
            }
            return false;
        }
    }
}
