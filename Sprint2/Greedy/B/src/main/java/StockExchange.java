import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class StockExchange {
    public static void main(String[] args) {
        /*ByteArrayInputStream bais = new ByteArrayInputStream(args[0].getBytes());
        System.setIn(bais);*/
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        if (n == 0){
            System.out.println("0");
            return;
        }
        String[] input = sc.nextLine().split(" ");
        int[] nums = new int[n+1];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        nums[n] = 0;

        int result = 0;
        int sell_today;
        int sell_tomorrow;
        for (int i = 0; i < n; i++) {
            result = result - nums[i]; //buy today
            sell_today = result + nums[i];
            sell_tomorrow = result + nums[i+1];
            if (sell_today > sell_tomorrow) result = sell_today;
            else result = sell_tomorrow;
        }

        System.out.println(result);
    }
}
