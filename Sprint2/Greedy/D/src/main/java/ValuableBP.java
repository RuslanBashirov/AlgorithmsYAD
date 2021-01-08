import java.util.Arrays;
import java.util.Scanner;

public class ValuableBP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        int volume = Integer.parseInt(s1);
        String s2 = sc.nextLine();
        int n = Integer.parseInt(s2);
        int[] prices = new int[n];
        int[] weights = new int[n];
        String [] strings;
        String curr_line;

        for (int i = 0; i < n; i++) {
            curr_line = sc.nextLine();
            strings = curr_line.split(" ");
            prices[i] = Integer.parseInt(strings[0]);
            weights[i] = Integer.parseInt(strings[1]);
        }

        int[] prices_suitable_temp = new int[n];
        int[] weights_suitable_temp = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (weights[i] <= volume){
                weights_suitable_temp[j] = weights[i];
                prices_suitable_temp[j] = prices[i];
                j++;
            }
        }
        int[] prices_suitable = Arrays.copyOf(prices_suitable_temp, j);
        int[] weights_suitable = Arrays.copyOf(weights_suitable_temp, j);

        int curr_max_price_index = 0;
        for (int i = 0; i < prices_suitable.length; i++) {
            for (int k = i+1; k < prices_suitable.length - 1; k++) {
                if (prices_suitable[k] > prices_suitable[curr_max_price_index]) {
                    exchange2Nums(prices_suitable, weights_suitable, k, curr_max_price_index);
                }
                else if (prices_suitable[k] == prices_suitable[curr_max_price_index] &&
                            weights_suitable[k] < weights_suitable[curr_max_price_index]){
                    exchange2Nums(prices_suitable, weights_suitable, k, curr_max_price_index);
                }
            }
            curr_max_price_index++;
        }
        int x = 0;
        while (volume >= 0){
            volume = volume - weights_suitable[x];
            x++;
        }
    }


    static void exchange2Nums(int[] prices_suitable, int[] weights_suitable, int k, int curr_max_price_index){
        int temp_price, temp_weight;
        temp_price = prices_suitable[curr_max_price_index];
        temp_weight = weights_suitable[curr_max_price_index];
        prices_suitable[curr_max_price_index] = prices_suitable[k];
        weights_suitable[curr_max_price_index] = weights_suitable[k];
        prices_suitable[k] = temp_price;
        weights_suitable[k] = temp_weight;
    }

}
