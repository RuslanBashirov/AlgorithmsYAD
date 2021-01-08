import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BackPack {
    public static void main(String[] args) {
        /*ByteArrayInputStream bais = new ByteArrayInputStream(args[0].getBytes());
        System.setIn(bais);*/
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        int volume = Integer.parseInt(s1);
        String s2 = sc.nextLine();
        int n = Integer.parseInt(s2);
        int[] prices = new int[n+1];
        int[] weights = new int[n+1];
        String [] strings;
        String curr_line;

        for (int i = 0; i < n; i++) {
            curr_line = sc.nextLine();
            strings = curr_line.split(" ");
            prices[i] = Integer.parseInt(strings[0]);
            weights[i] = Integer.parseInt(strings[1]);
        }
        prices[n] = 0;
        weights[n] = 0;

        ArrayList<Integer> result = new ArrayList<Integer>();

        while (volume > 0){
            int max_price_index = n;

            for (int i = 0; i < n; i++) {
                if (prices[i] > prices[max_price_index] && weights[i] <= volume){
                    max_price_index = i;
                }
                else if (prices[i] == prices[max_price_index] && weights[i] < weights[max_price_index]){
                    max_price_index = i;
                }
            }
            volume = volume - weights[max_price_index];
            if (volume < 0 || max_price_index == n) break;
            prices[max_price_index] = 0;
            weights[max_price_index] = 0;
            result.add(max_price_index);
        }

        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

}
