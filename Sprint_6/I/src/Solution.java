import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static int[] computePrefix(StringBuilder input) {
        int[] pi = new int[input.length()];
        int k = 0;
        for (int q = 1; q < input.length(); q++) {
            char target = input.charAt(q);
            while (k > 0 && input.charAt(k) != target) {
                k = pi[k - 1];
            }
            if (input.charAt(k) == target) {
                k++;
            }
            pi[q] = k;
        }
        return pi;
    }

    public static String getMaxPrefixString(String s1, String s2){
        StringBuilder s = new StringBuilder(s1).append("#").append(s2);
        int[] prefix_array = computePrefix(s);
        int max_prefix_val = 0;

        for (int i = s1.length()+1; i < prefix_array.length; i++) {
            if (prefix_array[i] > max_prefix_val) max_prefix_val = prefix_array[i];
        }

        return s.substring(0, max_prefix_val);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(reader.readLine());

        if (n == 0){
            System.out.println(0);
            return;
        }

        //String[] strings = new String[n];
        String result = reader.readLine();

        for (int i = 1; i < n; i++) {
            result = getMaxPrefixString(result, reader.readLine());
            //strings[i] = reader.readLine();
        }

        reader.close();

        System.out.println(result.length());

    }
}
