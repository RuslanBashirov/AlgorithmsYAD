import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class E {
    public static int max_length = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(reader.readLine());

        if (n == 0){
            System.out.println(0);
            return;
        }
        String s = reader.readLine();
        reader.close();
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < s.length(); i+=2) {
            str.append(s.charAt(i));
        }

        //String str = sb.toString();

        int sum_i = 0, sum_j;

        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '0') sum_i--;
            else sum_i++;

            if (sum_i == 0) max_length = i+1;

            sum_j = sum_i;


            for (int j = 0; j < i; j++) {
                if (str.charAt(j) == '0') sum_j++;
                else sum_j--;

                if ((sum_j == 0) && (i - j > max_length)) max_length = i - j;
            }
        }

        System.out.println(max_length);
    }
}
