import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class HousePrices {
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        String[] s1 = reader.readLine().split(" ");
        String[] s2 = reader.readLine().split(" ");
        reader.close();
        int n = Integer.parseInt(s1[0]);
        int k = Integer.parseInt(s1[1]);
        int[] prices = new int[n];

        for (int i = 0; i < n; i++) {
            prices[i] = Integer.parseInt(s2[i]);
        }

        Arrays.sort(prices);

        int j = 0;

        for (; j < n; j++) {
            k -= prices[j];
            if (k < 0) break;
        }

        System.out.println(j);
    }
}
