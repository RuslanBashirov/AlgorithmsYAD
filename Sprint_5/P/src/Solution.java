import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(reader.readLine());

        if (n == 0) return;

        String[] arr1 = reader.readLine().split(" ");
        int m = Integer.parseInt(reader.readLine());
        String[] arr2 = {};

        if (m > 0)
        arr2 = reader.readLine().split(" ");

        reader.close();

        int maxLength = Math.max(n, m);

        for (int i = 0; i < maxLength; i++) {
            if (i < n) System.out.print(arr1[i]+": ");
            else return;

            if (i < m) System.out.println(arr2[i]);
            else System.out.println("None");
        }
    }
}
